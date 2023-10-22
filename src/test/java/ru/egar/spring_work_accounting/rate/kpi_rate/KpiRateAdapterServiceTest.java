package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.KPI_RATE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KpiRateAdapterServiceTest {

    @Mock
    private KpiRateService kpiRateService;

    @Mock
    private KpiRateRequestMapper kpiRateRequestMapper;

    @Mock
    private KpiRateDtoMapper kpiRateDtoMapper;

    @InjectMocks
    private KpiRateAdapterService kpiRateAdapterService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find kpi rate by id")
    void findByIdTest() {
        when(kpiRateService.findById(any())).thenReturn(KPI_RATE);
        when(kpiRateDtoMapper.map(any())).thenReturn(KPI_RATE_DTO);
        var result = kpiRateAdapterService.findById(KPI_RATE_ID);
        verify(kpiRateService, times(1)).findById(KPI_RATE_ID);
        verify(kpiRateDtoMapper, times(1)).map(KPI_RATE);
        assertEquals(KPI_RATE_DTO, result);
    }

    @Test
    @Order(2)
    @DisplayName("Save kpi rate")
    void saveTest() {
        when(kpiRateService.save(any())).thenReturn(KPI_RATE_ID);
        when(kpiRateRequestMapper.map(any())).thenReturn(KPI_RATE);
        var result = kpiRateAdapterService.save(KPI_RATE_REQUEST);
        verify(kpiRateService, times(1)).save(KPI_RATE);
        verify(kpiRateRequestMapper, times(1)).map(KPI_RATE_REQUEST);
        assertEquals(KPI_RATE_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Update kpi rate")
    void updateTest() {
        when(kpiRateService.update(any(), any())).thenReturn(KPI_RATE_ID);
        when(kpiRateRequestMapper.map(any())).thenReturn(KPI_RATE);
        var result = kpiRateAdapterService.update(KPI_RATE_REQUEST, KPI_RATE_ID);
        verify(kpiRateService, times(1)).update(KPI_RATE, KPI_RATE_ID);
        verify(kpiRateRequestMapper, times(1)).map(KPI_RATE_REQUEST);
        assertEquals(KPI_RATE_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Delete kpi rate")
    void deleteTest() {
        kpiRateAdapterService.delete(KPI_RATE_ID);
        verify(kpiRateService, times(1)).delete(KPI_RATE_ID);
    }

}