package ru.egar.spring_work_accounting.define.payment_strategy;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TIME_STATUS_TURNOUT;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DefineComputePaymentServiceTest {

    @InjectMocks
    private DefineComputePaymentService defineComputePaymentService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    void defineStrategyTest() {
        var result = defineComputePaymentService.defineStrategy(TIME_STATUS_TURNOUT);
        assertEquals(ComputeTurnoutStrategy.class, result.getClass());
    }
}