package ru.egar.spring_work_accounting.employee.employee_interaction;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TASK_ID;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE_INTERACTION_REQUEST;
import static ru.egar.spring_work_accounting.util.TestModels.TASK_DTO_LIST;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeInteractionControllerTest {

    @Mock
    private EmployeeInteractionService employeeInteractionService;

    @InjectMocks
    private EmployeeInteractionController employeeInteractionController;


    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Get all available tasks")
    void getAvailableTasksTest() {
        when(employeeInteractionService.getAvailableTasks()).thenReturn(TASK_DTO_LIST);
        var response = employeeInteractionController.getAvailableTasks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TASK_DTO_LIST, response.getBody());
        verify(employeeInteractionService, times(1)).getAvailableTasks();
        verifyNoMoreInteractions(employeeInteractionService);
    }

    @Test
    @Order(2)
    @DisplayName("Start task")
    void startTaskTest() {
        when(employeeInteractionService.startTask(any())).thenReturn(TASK_ID);
        var response = employeeInteractionController.startTask(EMPLOYEE_INTERACTION_REQUEST);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TASK_ID, response.getBody());
        verify(employeeInteractionService, times(1)).startTask(EMPLOYEE_INTERACTION_REQUEST);
        verifyNoMoreInteractions(employeeInteractionService);
    }

    @Test
    @Order(3)
    @DisplayName("Finish task")
    void finishTaskTest() {
        when(employeeInteractionService.finishTask(any())).thenReturn(TASK_ID);
        var response = employeeInteractionController.finishTask(EMPLOYEE_INTERACTION_REQUEST);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TASK_ID, response.getBody());
        verify(employeeInteractionService, times(1)).finishTask(EMPLOYEE_INTERACTION_REQUEST);
        verifyNoMoreInteractions(employeeInteractionService);
    }

}