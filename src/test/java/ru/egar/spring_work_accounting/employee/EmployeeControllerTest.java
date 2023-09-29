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
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

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
        when(employeeService.save(EMPLOYEE)).thenReturn(EMPLOYEE_ID);
        var response = employeeController.createEmployee(EMPLOYEE);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(EMPLOYEE_ID, response.getBody());
        verify(employeeService, times(1)).save(EMPLOYEE);
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    @Order(2)
    @DisplayName("Find employee by id")
    public void findEmployeeByIdTest() {
        when(employeeService.findById(EMPLOYEE_ID)).thenReturn(EMPLOYEE);
        var response = employeeController.findEmployeeById(EMPLOYEE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(EMPLOYEE, response.getBody());
        verify(employeeService, times(1)).findById(EMPLOYEE_ID);
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    @Order(3)
    @DisplayName("Update employee")
    public void updateEmployeeTest() {
        when(employeeService.update(EMPLOYEE, EMPLOYEE_ID)).thenReturn(EMPLOYEE_ID);
        var response = employeeController.updateEmployee(EMPLOYEE, EMPLOYEE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(EMPLOYEE_ID, response.getBody());
        verify(employeeService, times(1)).update(EMPLOYEE, EMPLOYEE_ID);
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    @Order(4)
    @DisplayName("Delete employee")
    public void deleteEmployeeTest() {
        var response = employeeController.deleteEmployee(EMPLOYEE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(employeeService, times(1)).delete(EMPLOYEE_ID);
        verifyNoMoreInteractions(employeeService);
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