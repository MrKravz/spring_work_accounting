package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
public class ComputeTotalServiceTest {

    @Mock
    private ComputeSalaryService computeSalaryService;
    @Mock
    private ComputeTimeService computeTimeService;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private TimeSheetRepository timeSheetRepository;

    @InjectMocks
    private ComputeTotalService computeTotalService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    public void computeHoursSalaryTest() {
        when(computeSalaryService.computeHoursSalary(any(), anyInt(), any())).thenReturn(EXPECTED_SALARY);
        when(computeTimeService.computeTime(any(), any(), any(), any())).thenReturn(EXPECTED_TIME);
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(EMPLOYEE));
        when(timeSheetRepository.findDistinctByTimeStatus()).thenReturn(DISTINCT_TIME_STATUSES);
        var result = computeTotalService.computeTotal(EMPLOYEE_ID, DATE_START, DATE_END);
        assertEquals(TOTAL.getTotalWorkedTime(), result.getTotalWorkedTime());
        assertEquals(TOTAL.getTotalSalary(), result.getTotalSalary());
    }

}
