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

    @Override
    @Transactional
    public Long save(Task entity) {
        entity.setTaskStatus(TaskStatus.NOT_STARTED);
        return taskRepository.save(entity).getId();
    }

    @Override
    @Transactional
    public Long update(Task entity, Long id) {
        var taskToUpdate = findById(id);
        taskToUpdate.setShortName(entity.getShortName());
        taskToUpdate.setDescription(entity.getDescription());
        taskToUpdate.setTaskStatus(entity.getTaskStatus());
        taskToUpdate.setTaskPointsNumber(entity.getTaskPointsNumber());
        taskToUpdate.setDateTimeStart(entity.getDateTimeStart());
        taskToUpdate.setDateTimeEnd(entity.getDateTimeEnd());
        taskToUpdate.setEmployee(entity.getEmployee());
        var result = taskRepository.save(taskToUpdate);
        return result.getId();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
