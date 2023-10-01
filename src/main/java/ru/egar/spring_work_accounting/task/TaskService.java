package ru.egar.spring_work_accounting.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TaskService implements CrudService<Task, UUID> {

    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(UUID id) {
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    @Transactional
    @Override
    public UUID save(Task entity) {
        return taskRepository.save(entity).getId();
    }

    @Transactional
    @Override
    public UUID update(Task entity, UUID id) {
        return taskRepository.save(entity).getId();
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }

}
