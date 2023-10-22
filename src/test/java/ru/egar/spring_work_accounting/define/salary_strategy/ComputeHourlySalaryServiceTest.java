package ru.egar.spring_work_accounting.define.salary_strategy;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.compute.salary.ComputeHoursSalaryService;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE;
import static ru.egar.spring_work_accounting.util.TestModels.HOUR_RATE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputeHourlySalaryServiceTest {

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
        when(computeTimeService.computeTime(EMPLOYEE, TIME_STATUS_TURNOUT, DATE_START, DATE_END)).thenReturn(EXPECTED_TIME);
        when(computeHoursSalaryService.computeHoursSalary(HOUR_RATE, EXPECTED_TIME, TIME_STATUS_TURNOUT)).thenReturn(EXPECTED_SALARY);
        var result = computeHourlySalaryService.computeSalary(EMPLOYEE, DATE_START, DATE_END);
        assertEquals(EXPECTED_SALARY, result);
    }

}