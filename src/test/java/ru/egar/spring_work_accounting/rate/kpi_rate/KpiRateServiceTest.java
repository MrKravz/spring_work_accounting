package ru.egar.spring_work_accounting.rate.kpi_rate;

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
import static ru.egar.spring_work_accounting.util.TestConstants.KPI_RATE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.KPI_RATE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KpiRateServiceTest {

    @Mock
    private KpiRateRepository kpiRateRepository;

    @InjectMocks
    private KpiRateService kpiRateService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void findById() {
        when(kpiRateRepository.findById(any())).thenReturn(Optional.ofNullable(KPI_RATE));
        var result = kpiRateService.findById(KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).findById(KPI_RATE_ID);
        assertEquals(KPI_RATE, result);
    }

    @Test
    void save() {
        when(kpiRateRepository.save(any())).thenReturn(KPI_RATE);
        var result = kpiRateService.save(KPI_RATE);
        verify(kpiRateRepository, times(1)).save(KPI_RATE);
        assertEquals(KPI_RATE_ID, result);
    }

    @Test
    void update() {
        when(kpiRateRepository.save(any())).thenReturn(KPI_RATE);
        var result = kpiRateService.update(KPI_RATE, KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).save(KPI_RATE);
        assertEquals(KPI_RATE_ID, result);
    }

    @Test
    void delete() {
        kpiRateService.delete(KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).deleteById(KPI_RATE_ID);
    }

}