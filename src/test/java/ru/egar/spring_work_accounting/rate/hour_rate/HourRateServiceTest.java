package ru.egar.spring_work_accounting.rate.hour_rate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.HOUR_RATE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.HOUR_RATE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HourRateServiceTest {

    @Mock
    private HourRateRepository hourRateRepository;

    @InjectMocks
    private HourRateService hourRateService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void findById() {
        when(hourRateRepository.findById(any())).thenReturn(Optional.ofNullable(HOUR_RATE));
        var result = hourRateService.findById(HOUR_RATE_ID);
        verify(hourRateRepository, times(1)).findById(HOUR_RATE_ID);
        assertEquals(HOUR_RATE, result);
    }

    @Test
    void save() {
        when(hourRateRepository.save(any())).thenReturn(HOUR_RATE);
        var result = hourRateService.save(HOUR_RATE);
        verify(hourRateRepository, times(1)).save(HOUR_RATE);
        assertEquals(HOUR_RATE_ID, result);
    }

    @Test
    void update() {
        when(hourRateRepository.save(any())).thenReturn(HOUR_RATE);
        var result = hourRateService.update(HOUR_RATE, HOUR_RATE_ID);
        verify(hourRateRepository, times(1)).save(HOUR_RATE);
        assertEquals(HOUR_RATE_ID, result);
    }

    @Test
    void delete() {
        hourRateService.delete(HOUR_RATE_ID);
        verify(hourRateRepository, times(1)).deleteById(HOUR_RATE_ID);
    }

}