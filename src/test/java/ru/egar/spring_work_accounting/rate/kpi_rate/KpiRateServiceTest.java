package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.junit.jupiter.api.*;
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
    @Order(1)
    @DisplayName("Find kpi rate by id")
    void findByIdTest() {
        when(kpiRateRepository.findById(any())).thenReturn(Optional.ofNullable(KPI_RATE));
        var result = kpiRateService.findById(KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).findById(KPI_RATE_ID);
        assertEquals(KPI_RATE, result);
    }

    @Test
    @Order(2)
    @DisplayName("Save kpi rate")
    void saveTest() {
        when(kpiRateRepository.save(any())).thenReturn(KPI_RATE);
        var result = kpiRateService.save(KPI_RATE);
        verify(kpiRateRepository, times(1)).save(KPI_RATE);
        assertEquals(KPI_RATE_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Update kpi rate")
    void updateTest() {
        when(kpiRateRepository.findById(any())).thenReturn(Optional.ofNullable(KPI_RATE));
        when(kpiRateRepository.save(any())).thenReturn(KPI_RATE);
        var result = kpiRateService.update(KPI_RATE, KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).findById(KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).save(KPI_RATE);
        assertEquals(KPI_RATE_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Delete kpi rate")
    void deleteTest() {
        when(kpiRateRepository.findById(any())).thenReturn(Optional.ofNullable(KPI_RATE));
        when(kpiRateRepository.save(any())).thenReturn(KPI_RATE);
        kpiRateService.delete(KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).findById(KPI_RATE_ID);
        verify(kpiRateRepository, times(1)).save(KPI_RATE);
    }

}