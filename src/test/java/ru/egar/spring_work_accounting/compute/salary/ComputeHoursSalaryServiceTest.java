package ru.egar.spring_work_accounting.compute.salary;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.define.payment_strategy.ComputeTurnoutStrategy;
import ru.egar.spring_work_accounting.define.payment_strategy.DefineComputePaymentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.HOUR_RATE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputeHoursSalaryServiceTest {

    @Mock
    private DefineComputePaymentService defineComputePaymentService;

    @InjectMocks
    private ComputeHoursSalaryService computeHoursSalaryService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Compute hours salary")
    void computeHoursSalary() {
        when(defineComputePaymentService.defineStrategy(any())).thenReturn(new ComputeTurnoutStrategy());
        var result = computeHoursSalaryService.computeHoursSalary(HOUR_RATE, EXPECTED_TIME, TIME_STATUS_TURNOUT);
        assertEquals(EXPECTED_SALARY, result);
    }

}