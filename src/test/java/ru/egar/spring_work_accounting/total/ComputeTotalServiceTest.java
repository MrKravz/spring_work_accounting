package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.compute.kpi.ComputeKpiService;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;
import ru.egar.spring_work_accounting.define.salary_strategy.ComputeKpiSalaryService;
import ru.egar.spring_work_accounting.define.salary_strategy.DefineComputeSalaryService;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputeTotalServiceTest {

    @Mock
    private ComputeTimeService computeTimeService;

    @Mock
    private ComputeKpiSalaryService computeKpiSalaryService;

    @Mock
    private ComputeKpiService computeKpiService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DefineComputeSalaryService defineComputeSalaryService;

    @Mock
    private TimeSheetRepository timeSheetRepository;

    @InjectMocks
    private ComputeTotalService computeTotalService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        TOTAL.setTotalSalary(EXPECTED_TOTAL_SALARY);
    }

    @Test
    @Order(1)
    void computeTotal() {
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(EMPLOYEE));
        when(timeSheetRepository.findDistinctByTimeStatus()).thenReturn(DISTINCT_TIME_STATUSES);
        when(defineComputeSalaryService.defineStrategy(any())).thenReturn(new ComputeKpiSalaryService(computeKpiService));
        when(computeKpiSalaryService.computeSalary(any(), any(), any())).thenReturn(EXPECTED_SALARY);
        when(computeKpiService.computeKpi(any(), any(), any())).thenReturn(EXPECTED_TOTAL_KPI);
        when(computeTimeService.computeTime(any(), any(), any(), any())).thenReturn(EXPECTED_TIME);
        var result = computeTotalService.computeTotal(EMPLOYEE_ID, DATE_START, DATE_END);
        verify(employeeRepository, times(1)).findById(EMPLOYEE_ID);
        verify(timeSheetRepository, times(1)).findDistinctByTimeStatus();
        assertEquals(TOTAL.getTotalWorkedTime(), result.getTotalWorkedTime());
        assertEquals(TOTAL.getKpiPercentage(), result.getKpiPercentage());
        assertEquals(TOTAL.getTotalSalary(), result.getTotalSalary());
    }

}