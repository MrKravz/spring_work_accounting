package ru.egar.spring_work_accounting.rate.hour_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HourRateRequestMapperTest {

    @InjectMocks
    private HourRateRequestMapperImpl hourRateRequestMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to entity")
    public void mapTest() {
        var result = hourRateRequestMapper.map(HOUR_RATE_REQUEST);
        assertEquals(HOUR_RATE.getTurnoutRate(), result.getTurnoutRate());
        assertEquals(HOUR_RATE.getVacationRate(), result.getVacationRate());
        assertEquals(HOUR_RATE.getSickDaysRate(), result.getSickDaysRate());
        assertEquals(HOUR_RATE.getAbsenceRate(), result.getAbsenceRate());
        assertEquals(HOUR_RATE.getBusinessTripRate(), result.getBusinessTripRate());
        assertEquals(HOUR_RATE.getOverTimeRate(), result.getOverTimeRate());
        assertEquals(HOUR_RATE.getPosition(), result.getPosition());
        assertEquals(HOUR_RATE.getGrade(), result.getGrade());
    }

}
