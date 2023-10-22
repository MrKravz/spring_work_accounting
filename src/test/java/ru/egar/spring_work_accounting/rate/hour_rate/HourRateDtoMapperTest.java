package ru.egar.spring_work_accounting.rate.hour_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.HOUR_RATE;
import static ru.egar.spring_work_accounting.util.TestModels.HOUR_RATE_DTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HourRateDtoMapperTest {

    @InjectMocks
    private HourRateDtoMapperImpl hourRateDtoMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Map to dto")
    public void mapTest() {
        var result = hourRateDtoMapper.map(HOUR_RATE);
        assertEquals(HOUR_RATE_DTO.getId(), result.getId());
        assertEquals(HOUR_RATE_DTO.getTurnoutRate(), result.getTurnoutRate());
        assertEquals(HOUR_RATE_DTO.getVacationRate(), result.getVacationRate());
        assertEquals(HOUR_RATE_DTO.getSickDaysRate(), result.getSickDaysRate());
        assertEquals(HOUR_RATE_DTO.getAbsenceRate(), result.getAbsenceRate());
        assertEquals(HOUR_RATE_DTO.getBusinessTripRate(), result.getBusinessTripRate());
        assertEquals(HOUR_RATE_DTO.getOverTimeRate(), result.getOverTimeRate());
    }

    @Test
    @Order(2)
    @DisplayName("Remap to entity")
    public void remapTest() {
        var result = hourRateDtoMapper.remap(HOUR_RATE_DTO);
        assertEquals(HOUR_RATE.getId(), result.getId());
        assertEquals(HOUR_RATE.getTurnoutRate(), result.getTurnoutRate());
        assertEquals(HOUR_RATE.getVacationRate(), result.getVacationRate());
        assertEquals(HOUR_RATE.getSickDaysRate(), result.getSickDaysRate());
        assertEquals(HOUR_RATE.getAbsenceRate(), result.getAbsenceRate());
        assertEquals(HOUR_RATE.getBusinessTripRate(), result.getBusinessTripRate());
        assertEquals(HOUR_RATE.getOverTimeRate(), result.getOverTimeRate());
    }

}
