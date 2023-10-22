package ru.egar.spring_work_accounting.rate.hour_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.HOUR_RATE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HourRateAdapterServiceTest {

    @Mock
    private HourRateService hourRateService;

    @Mock
    private HourRateRequestMapper hourRateRequestMapper;

    @Mock
    private HourRateDtoMapper hourRateDtoMapper;

    @InjectMocks
    private HourRateAdapterService hourRateAdapterService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find hour rate by id")
    void findByIdTest() {
        when(hourRateService.findById(any())).thenReturn(HOUR_RATE);
        when(hourRateDtoMapper.map(any())).thenReturn(HOUR_RATE_DTO);
        var result = hourRateAdapterService.findById(HOUR_RATE_ID);
        verify(hourRateService, times(1)).findById(HOUR_RATE_ID);
        verify(hourRateDtoMapper, times(1)).map(HOUR_RATE);
        assertEquals(HOUR_RATE_DTO, result);
    }

    @Test
    @Order(2)
    @DisplayName("Save hour rate")
    void saveTest() {
        when(hourRateService.save(any())).thenReturn(HOUR_RATE_ID);
        when(hourRateRequestMapper.map(any())).thenReturn(HOUR_RATE);
        var result = hourRateAdapterService.save(HOUR_RATE_REQUEST);
        verify(hourRateService, times(1)).save(HOUR_RATE);
        verify(hourRateRequestMapper, times(1)).map(HOUR_RATE_REQUEST);
        assertEquals(HOUR_RATE_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Update hour rate")
    void updateTest() {
        when(hourRateService.update(any(), any())).thenReturn(HOUR_RATE_ID);
        when(hourRateRequestMapper.map(any())).thenReturn(HOUR_RATE);
        var result = hourRateAdapterService.update(HOUR_RATE_REQUEST, HOUR_RATE_ID);
        verify(hourRateService, times(1)).update(HOUR_RATE, HOUR_RATE_ID);
        verify(hourRateRequestMapper, times(1)).map(HOUR_RATE_REQUEST);
        assertEquals(HOUR_RATE_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Delete hour rate")
    void deleteTest() {
        hourRateAdapterService.delete(HOUR_RATE_ID);
        verify(hourRateService, times(1)).delete(HOUR_RATE_ID);
    }
}