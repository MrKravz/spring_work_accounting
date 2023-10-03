package ru.egar.spring_work_accounting.employee;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.EMPLOYEE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeAdapterService employeeAdapterService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Create employee")
    public void createEmployeeTest() {
        when(employeeAdapterService.save(any())).thenReturn(EMPLOYEE_ID);
        var response = employeeController.createEmployee(EMPLOYEE_REQUEST);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(EMPLOYEE_ID, response.getBody());
        verify(employeeAdapterService, times(1)).save(EMPLOYEE_REQUEST);
        verifyNoMoreInteractions(employeeAdapterService);
    }

    @Test
    @Order(2)
    @DisplayName("Find employee by id")
    public void findEmployeeByIdTest() {
        when(employeeAdapterService.findById(any())).thenReturn(EMPLOYEE_RESPONSE);
        var response = employeeController.findEmployeeById(EMPLOYEE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(EMPLOYEE_RESPONSE, response.getBody());
        verify(employeeAdapterService, times(1)).findById(EMPLOYEE_ID);
        verifyNoMoreInteractions(employeeAdapterService);
    }

    @Test
    @Order(3)
    @DisplayName("Update employee")
    public void updateEmployeeTest() {
        when(employeeAdapterService.update(any(), any())).thenReturn(EMPLOYEE_ID);
        var response = employeeController.updateEmployee(EMPLOYEE_REQUEST, EMPLOYEE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(EMPLOYEE_ID, response.getBody());
        verify(employeeAdapterService, times(1)).update(EMPLOYEE_REQUEST, EMPLOYEE_ID);
        verifyNoMoreInteractions(employeeAdapterService);
    }

    @Test
    @Order(4)
    @DisplayName("Delete employee")
    public void deleteEmployeeTest() {
        var response = employeeController.deleteEmployee(EMPLOYEE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(employeeAdapterService, times(1)).delete(EMPLOYEE_ID);
        verifyNoMoreInteractions(employeeAdapterService);
    }

    @Test
    @Order(5)
    @DisplayName("Handle EmployeeNotFoundException")
    public void handleEmployeeNotFoundExceptionTest() {
        EmployeeNotFoundException exception = new EmployeeNotFoundException();
        var response = employeeController.handleEmployeeNotFoundException(exception);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(exception.getMessage(), response.getBody().getMessage());
    }

}