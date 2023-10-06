package ru.egar.spring_work_accounting.define.salary_strategy;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.compute.salary.ComputeHoursSalaryService;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputeHourlySalaryServiceTest {

    @Mock
    private TimeSheetRepository timeSheetRepository;

    @Mock
    private ComputeTimeService computeTimeService;

    @Mock
    private ComputeHoursSalaryService computeHoursSalaryService;

    @InjectMocks
    private ComputeHourlySalaryService computeHourlySalaryService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Compute hourly salary")
    void computeSalaryTest() {
        when(computeTimeService.computeTime(any(), any(), any(), any())).thenReturn(EXPECTED_TIME);
        when(computeHoursSalaryService.computeHoursSalary(any(), anyInt(), any())).thenReturn(EXPECTED_SALARY);
        var result = computeHourlySalaryService.computeSalary(EMPLOYEE, DATE_START, DATE_END);
        assertEquals(EXPECTED_SALARY, result);
    }

}