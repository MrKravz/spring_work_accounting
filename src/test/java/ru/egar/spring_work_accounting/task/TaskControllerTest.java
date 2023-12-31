package ru.egar.spring_work_accounting.task;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TASK_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskControllerTest {

    @Mock
    private TaskAdapterService taskAdapterService;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find all tasks")
    public void findTasksTest() {
        when(taskAdapterService.findAll()).thenReturn(TASK_DTO_LIST);
        var response = taskController.findTasks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TASK_DTO_LIST, response.getBody());
        verify(taskAdapterService, times(1)).findAll();
        verifyNoMoreInteractions(taskAdapterService);
    }

    @Test
    @Order(2)
    @DisplayName("Create task")
    public void createTaskTest() {
        when(taskAdapterService.save(TASK_REQUEST)).thenReturn(TASK_ID);
        var response = taskController.createTask(TASK_REQUEST, mock(BindingResult.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(TASK_ID, response.getBody());
        verify(taskAdapterService, times(1)).save(TASK_REQUEST);
        verifyNoMoreInteractions(taskAdapterService);
    }

    @Test
    @Order(3)
    @DisplayName("Find task by id")
    public void findTaskByIdTest() {
        when(taskAdapterService.findById(TASK_ID)).thenReturn(TASK_DTO);
        var response = taskController.findTaskById(TASK_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TASK_DTO, response.getBody());
        verify(taskAdapterService, times(1)).findById(TASK_ID);
        verifyNoMoreInteractions(taskAdapterService);
    }

    @Test
    @Order(4)
    @DisplayName("Update task")
    public void updateTaskTest() {
        when(taskAdapterService.update(TASK_REQUEST, TASK_ID)).thenReturn(TASK_ID);
        var response = taskController.updateTask(TASK_REQUEST, TASK_ID, mock(BindingResult.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TASK_ID, response.getBody());
        verify(taskAdapterService, times(1)).update(TASK_REQUEST, TASK_ID);
        verifyNoMoreInteractions(taskAdapterService);
    }

    @Test
    @Order(5)
    @DisplayName("Delete task")
    public void deleteTaskTest() {
        var response = taskController.deleteTask(TASK_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(taskAdapterService, times(1)).delete(TASK_ID);
        verifyNoMoreInteractions(taskAdapterService);
    }

}