package ru.egar.spring_work_accounting.task;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TASK_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskAdapterServiceTest {

    @Mock
    private TaskService taskService;

    @Mock
    private TaskRequestMapper taskRequestMapper;

    @Mock
    private TaskDtoMapper taskDtoMapper;

    @InjectMocks
    private TaskAdapterService taskAdapterService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Find all tasks")
    void findAllTest() {
        when(taskService.findAll()).thenReturn(TASKS_LIST);
        when(taskDtoMapper.iterableMap(any())).thenReturn(TASK_DTO_LIST);
        var result = taskAdapterService.findAll();
        verify(taskService, times(1)).findAll();
        verify(taskDtoMapper, times(1)).iterableMap(TASKS_LIST);
        assertEquals(TASK_DTO_LIST, result);
    }

    @Test
    @Order(2)
    @DisplayName(value = "Find task by id")
    void findByIdTest() {
        when(taskService.findById(any())).thenReturn(TASK);
        when(taskDtoMapper.map(any())).thenReturn(TASK_DTO);
        var result = taskAdapterService.findById(TASK_ID);
        verify(taskService, times(1)).findById(TASK_ID);
        verify(taskDtoMapper, times(1)).map(TASK);
        assertEquals(TASK_DTO, result);
    }

    @Test
    @Order(3)
    @DisplayName(value = "Update task")
    void updateTest() {
        when(taskService.update(any(), any())).thenReturn(TASK_ID);
        when(taskRequestMapper.map(any())).thenReturn(TASK);
        var result = taskAdapterService.update(TASK_REQUEST, TASK_ID);
        verify(taskService, times(1)).update(TASK, TASK_ID);
        verify(taskRequestMapper, times(1)).map(TASK_REQUEST);
        assertEquals(TASK_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName(value = "Save task")
    void saveTest() {
        when(taskService.save(any())).thenReturn(TASK_ID);
        when(taskRequestMapper.map(any())).thenReturn(TASK);
        var result = taskAdapterService.save(TASK_REQUEST);
        verify(taskService, times(1)).save(TASK);
        verify(taskRequestMapper, times(1)).map(TASK_REQUEST);
        assertEquals(TASK_ID, result);
    }

    @Test
    @Order(5)
    @DisplayName(value = "Delete task by id")
    void deleteTest() {
        taskAdapterService.delete(TASK_ID);
        verify(taskService).delete(TASK_ID);
    }

}