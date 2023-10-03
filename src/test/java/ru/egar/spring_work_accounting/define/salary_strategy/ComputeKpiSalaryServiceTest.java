package ru.egar.spring_work_accounting.define.salary_strategy;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.compute.kpi.ComputeKpiService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputeKpiSalaryServiceTest {

    @Mock
    private ComputeKpiService computeKpiService;

    @InjectMocks
    private ComputeKpiSalaryService computeKpiSalaryService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Compute kpi salary")
    void computeSalary() {
        when(computeKpiService.computeKpi(any(), any(), any())).thenReturn(EXPECTED_TOTAL_KPI);
        var result = computeKpiSalaryService.computeSalary(EMPLOYEE, DATE_START, DATE_END);
        assertEquals(EXPECTED_TOTAL_SALARY, result);
    }
}