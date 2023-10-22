package ru.egar.spring_work_accounting.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskAdapterService implements CrudAdapterService<TaskRequest, TaskDto, Long> {

    private final TaskService taskService;
    private final TaskDtoMapper taskDtoMapper;
    private final TaskRequestMapper taskRequestMapper;

    public List<TaskDto> findAll() {
        return (List<TaskDto>) taskDtoMapper.iterableMap(taskService.findAll());
    }

    @Override
    public TaskDto findById(Long id) {
        return taskDtoMapper.map(taskService.findById(id));
    }

    @Override
    public Long save(TaskRequest entity) {
        var task = taskRequestMapper.map(entity);
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        return taskService.save(task);
    }

    @Override
    public Long update(TaskRequest entity, Long id) {
        var task = taskRequestMapper.map(entity);
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        return taskService.update(task, id);
    }

    @Override
    public void delete(Long id) {
        taskService.delete(id);
    }

}
