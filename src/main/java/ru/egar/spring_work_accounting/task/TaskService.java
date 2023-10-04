package ru.egar.spring_work_accounting.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TaskService implements CrudService<Task, Long> {

    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    @Transactional
    @Override
    public Long save(Task entity) {
        entity.setTaskStatus(TaskStatus.NOT_STARTED);
        return taskRepository.save(entity).getId();
    }

    @Transactional
    @Override
    public Long update(Task entity, Long id) {
        return taskRepository.save(entity).getId();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
