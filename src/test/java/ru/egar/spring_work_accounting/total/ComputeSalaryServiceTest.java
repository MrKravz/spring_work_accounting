package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.compute.salary.ComputeHoursSalaryService;
import ru.egar.spring_work_accounting.define.payment_strategy.ComputeTurnoutStrategy;
import ru.egar.spring_work_accounting.define.payment_strategy.DefineComputePaymentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.RATE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComputeSalaryServiceTest {

    @Mock
    private DefineComputePaymentService defineComputePaymentService;

    @InjectMocks
    private ComputeHoursSalaryService computeHoursSalaryService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    public void computeHoursSalaryTest() {
        when(defineComputePaymentService.defineStrategy(any())).thenReturn(new ComputeTurnoutStrategy());
        var result = computeHoursSalaryService.computeHoursSalary(RATE, EXPECTED_TIME, TIME_STATUS_TURNOUT);
        assertEquals(EXPECTED_SALARY, result);
    }
}
