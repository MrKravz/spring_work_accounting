package ru.egar.spring_work_accounting.employee.employee_interaction;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeService;
import ru.egar.spring_work_accounting.task.TaskDtoMapper;
import ru.egar.spring_work_accounting.task.TaskService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TASK_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeInteractionServiceTest {

    @Mock
    private EmployeeService employeeService;
    @Mock
    private TaskService taskService;
    @Mock
    private TaskDtoMapper taskDtoMapper;

    @InjectMocks
    private EmployeeInteractionService employeeInteractionService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Get all available tasks")
    void getAvailableTasksTest() {
        when(taskService.findAll()).thenReturn(TASKS_LIST);
        when(taskDtoMapper.iterableMap(anyIterable())).thenReturn(TASK_DTO_LIST);
        var result = employeeInteractionService.getAvailableTasks();
        assertEquals(TASK_DTO_LIST, result);
    }

    @Test
    @Order(2)
    @DisplayName("Start task")
    void startTaskTest() {
        when(taskService.findById(any())).thenReturn(NOT_STARTED_TASK);
        when(employeeService.findById(any())).thenReturn(EMPLOYEE);
        when(taskService.update(any() ,any())).thenReturn(TASK_ID);
        var result = employeeInteractionService.startTask(EMPLOYEE_INTERACTION_REQUEST);
        assertEquals(TASK_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Finish task")
    void finishTaskTest() {
        when(taskService.findById(any())).thenReturn(IN_PROCESS_TASK);
        when(taskService.update(any() ,any())).thenReturn(TASK_ID);
        var result = employeeInteractionService.finishTask(EMPLOYEE_INTERACTION_REQUEST);
        assertEquals(TASK_ID, result);
    }
}