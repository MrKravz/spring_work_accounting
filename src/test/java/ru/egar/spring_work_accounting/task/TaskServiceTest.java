package ru.egar.spring_work_accounting.task;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TASK_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find all tasks")
    void findAllTest() {
        when(taskRepository.findAll()).thenReturn(TASKS_LIST);
        var result = taskService.findAll();
        verify(taskRepository, times(1)).findAll();
        assertEquals(TASKS_LIST, result);
    }

    @Test
    @Order(2)
    @DisplayName("Find task by id")
    void findByIdTest() {
        when(taskRepository.findById(any())).thenReturn(Optional.ofNullable(FINISHED_TASK));
        var result = taskService.findById(TASK_ID);
        verify(taskRepository, times(1)).findById(TASK_ID);
        assertEquals(FINISHED_TASK, result);
    }

    @Test
    @Order(3)
    @DisplayName("Update task")
    void updateTest() {
        when(taskRepository.findById(any())).thenReturn(Optional.ofNullable(FINISHED_TASK));
        when(taskRepository.save(any())).thenReturn(FINISHED_TASK);
        var result = taskService.update(FINISHED_TASK, TASK_ID);
        verify(taskRepository, times(1)).findById(TASK_ID);
        verify(taskRepository, times(1)).save(FINISHED_TASK);
        assertEquals(TASK_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Save task")
    void saveTest() {
        when(taskRepository.save(any())).thenReturn(FINISHED_TASK);
        var result = taskService.save(FINISHED_TASK);
        verify(taskRepository, times(1)).save(FINISHED_TASK);
        assertEquals(TASK_ID, result);
    }

    @Test
    @Order(5)
    @DisplayName("Delete task by id")
    void deleteTest() {
        taskService.delete(TASK_ID);
        verify(taskRepository).deleteById(TASK_ID);
    }

}