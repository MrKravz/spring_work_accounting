package ru.egar.spring_work_accounting.compute.kpi;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComputeKpiServiceTest {

    @InjectMocks
    private ComputeKpiService computeKpiService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    public void computeKpiTest() {
        var result = computeKpiService.computeKpi(EMPLOYEE, DATE_START, DATE_END);
        assertEquals(EXPECTED_TOTAL_KPI, result);
    }
}
