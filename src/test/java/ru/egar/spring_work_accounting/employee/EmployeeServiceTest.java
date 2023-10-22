package ru.egar.spring_work_accounting.employee;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.EMPLOYEE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Find employee by id")
    void findByIdTest() {
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(EMPLOYEE));
        var result = employeeService.findById(EMPLOYEE_ID);
        verify(employeeRepository, times(1)).findById(EMPLOYEE_ID);
        assertEquals(EMPLOYEE, result);
    }

    @Test
    @Order(2)
    @DisplayName(value = "Update employee")
    void updateTest() {
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(EMPLOYEE));
        when(employeeRepository.save(any())).thenReturn(EMPLOYEE);
        var result = employeeService.update(EMPLOYEE, EMPLOYEE_ID);
        verify(employeeRepository, times(1)).findById(EMPLOYEE_ID);
        verify(employeeRepository, times(1)).save(EMPLOYEE);
        assertEquals(EMPLOYEE_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName(value = "Save employee")
    void saveTest() {
        when(employeeRepository.save(any())).thenReturn(EMPLOYEE);
        var result = employeeService.save(EMPLOYEE);
        verify(employeeRepository, times(1)).save(EMPLOYEE);
        assertEquals(EMPLOYEE_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName(value = "Delete employee by id")
    void deleteTest() {
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(EMPLOYEE));
        when(employeeRepository.save(any())).thenReturn(EMPLOYEE);
        employeeService.delete(EMPLOYEE_ID);
        verify(employeeRepository, times(1)).findById(EMPLOYEE_ID);
        verify(employeeRepository, times(1)).save(EMPLOYEE);
    }

}
