package ru.egar.spring_work_accounting.define.salary_strategy;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.rate.hour_rate.PaymentSystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DefineComputeSalaryServiceTest {

    @Mock
    private ComputeHourlySalaryService computeHourlySalaryService;

    @Mock
    private ComputeKpiSalaryService computeKpiSalaryService;

    @InjectMocks
    private DefineComputeSalaryService defineComputeSalaryService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Define compute salary strategy")
    void defineStrategyTest() {
        var result = defineComputeSalaryService.defineStrategy(PaymentSystem.KPI_PAYMENT);
        assertEquals(ComputeKpiSalaryService.class, result.getClass());
    }
}