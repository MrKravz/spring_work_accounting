package ru.egar.spring_work_accounting.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskAdapterService implements CrudAdapterService<TaskRequest, TaskResponse, UUID> {

    private final TaskService taskService;
    private final TaskResponseMapper taskResponseMapper;
    private final TaskRequestMapper taskRequestMapper;

    public List<TaskResponse> findAll() {
        return (List<TaskResponse>) taskResponseMapper.iterableMap(taskService.findAll());
    }

    @Override
    public TaskResponse findById(UUID id) {
        return taskResponseMapper.map(taskService.findById(id));
    }

    @Override
    public UUID save(TaskRequest entity) {
        return taskService.save(taskRequestMapper.map(entity));
    }

    @Override
    public UUID update(TaskRequest entity, UUID id) {
        return taskService.update(taskRequestMapper.map(entity), id);
    }

    @Override
    public void delete(UUID id) {
        taskService.delete(id);
    }

}
