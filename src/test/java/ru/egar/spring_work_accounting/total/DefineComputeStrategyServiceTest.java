package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TIME_STATUS_TURNOUT;
import static ru.egar.spring_work_accounting.util.TestModels.EXPECTED_STRATEGY;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DefineComputeStrategyServiceTest {

    @InjectMocks
    private DefineComputeStrategyService defineComputeStrategyService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    public void computeHoursSalaryTest() {
        var result = defineComputeStrategyService.defineComputeStrategy(TIME_STATUS_TURNOUT);
        assertEquals(EXPECTED_STRATEGY.getClass(), result.getClass());
    }

}
