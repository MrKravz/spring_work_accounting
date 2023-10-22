package ru.egar.spring_work_accounting.employee;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateService;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.EMPLOYEE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAdapterServiceTest {

    @Mock
    private EmployeeService employeeService;
    @Mock
    private EmployeeRequestMapper employeeRequestMapper;
    @Mock
    private EmployeeDtoMapper employeeDtoMapper;
    @Mock
    private HourRateService hourRateService;
    @Mock
    private KpiRateService kpiRateService;

    @InjectMocks
    private EmployeeAdapterService employeeAdapterService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Find employee by id")
    void findByIdTest() {
        when(employeeService.findById(any())).thenReturn(EMPLOYEE);
        when(employeeDtoMapper.map(any())).thenReturn(EMPLOYEE_DTO);
        var result = employeeAdapterService.findById(EMPLOYEE_ID);
        verify(employeeService, times(1)).findById(EMPLOYEE_ID);
        verify(employeeDtoMapper, times(1)).map(EMPLOYEE);
        assertEquals(EMPLOYEE_DTO, result);
    }

    @Test
    @Order(2)
    @DisplayName(value = "Update employee")
    void updateTest() {
        when(employeeService.update(any(), any())).thenReturn(EMPLOYEE_ID);
        when(employeeRequestMapper.map(any())).thenReturn(EMPLOYEE);
        var result = employeeAdapterService.update(EMPLOYEE_REQUEST, EMPLOYEE_ID);
        verify(employeeService, times(1)).update(EMPLOYEE, EMPLOYEE_ID);
        verify(employeeRequestMapper, times(1)).map(EMPLOYEE_REQUEST);
        assertEquals(EMPLOYEE_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName(value = "Save employee")
    void saveTest() {
        when(hourRateService.findByPositionAndGrade(any(), any())).thenReturn(HOUR_RATE);
        when(kpiRateService.findByPositionAndGrade(any(), any())).thenReturn(KPI_RATE);
        when(employeeService.save(any())).thenReturn(EMPLOYEE_ID);
        when(employeeRequestMapper.map(any())).thenReturn(EMPLOYEE);
        var result = employeeAdapterService.save(EMPLOYEE_REQUEST);
        verify(employeeService, times(1)).save(EMPLOYEE);
        verify(employeeRequestMapper, times(1)).map(EMPLOYEE_REQUEST);
        verify(hourRateService, times(1)).findByPositionAndGrade(Position.DEVELOPER, Grade.JUNIOR);
        verify(kpiRateService, times(1)).findByPositionAndGrade(Position.DEVELOPER, Grade.JUNIOR);
        assertEquals(EMPLOYEE_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName(value = "Delete employee by id")
    void deleteTest() {
        employeeAdapterService.delete(EMPLOYEE_ID);
        verify(employeeService).delete(EMPLOYEE_ID);
    }

}