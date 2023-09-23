package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import ru.egar.spring_work_accounting.define.payment_strategy.DefineComputePaymentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TIME_STATUS_TURNOUT;
import static ru.egar.spring_work_accounting.util.TestModels.EXPECTED_STRATEGY;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DefineComputePaymentServiceTest {

    @InjectMocks
    private DefineComputePaymentService defineComputePaymentService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    public void computeHoursSalaryTest() {
        var result = defineComputePaymentService.defineStrategy(TIME_STATUS_TURNOUT);
        assertEquals(EXPECTED_STRATEGY.getClass(), result.getClass());
    }

}
