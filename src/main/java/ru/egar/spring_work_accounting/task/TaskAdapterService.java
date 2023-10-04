package ru.egar.spring_work_accounting.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskAdapterService implements CrudAdapterService<TaskRequest, TaskResponse, Long> {

    private final TaskService taskService;
    private final TaskResponseMapper taskResponseMapper;
    private final TaskRequestMapper taskRequestMapper;

    public List<TaskResponse> findAll() {
        return (List<TaskResponse>) taskResponseMapper.iterableMap(taskService.findAll());
    }

    @Override
    public TaskResponse findById(Long id) {
        return taskResponseMapper.map(taskService.findById(id));
    }

    @Override
    public Long save(TaskRequest entity) {
        return taskService.save(taskRequestMapper.map(entity));
    }

    @Override
    public Long update(TaskRequest entity, Long id) {
        return taskService.update(taskRequestMapper.map(entity), id);
    }

    @Override
    public void delete(Long id) {
        taskService.delete(id);
    }

}
