package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.KPI_RATE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.KPI_RATE_DTO;
import static ru.egar.spring_work_accounting.util.TestModels.KPI_RATE_REQUEST;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KpiRateControllerTest {

    @Mock
    private KpiRateAdapterService kpiRateAdapterService;

    @InjectMocks
    private KpiRateController kpiRateController;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Create kpi rate")
    public void createHourRateTest() {
        when(kpiRateAdapterService.save(any())).thenReturn(KPI_RATE_ID);
        var response = kpiRateController.createKpiRate(KPI_RATE_REQUEST, mock(BindingResult.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(KPI_RATE_ID, response.getBody());
        verify(kpiRateAdapterService, times(1)).save(KPI_RATE_REQUEST);
        verifyNoMoreInteractions(kpiRateAdapterService);
    }

    @Test
    @Order(2)
    @DisplayName("Find kpi rate by id")
    public void findEmployeeByIdTest() {
        when(kpiRateAdapterService.findById(any())).thenReturn(KPI_RATE_DTO);
        var response = kpiRateController.findKpiRateById(KPI_RATE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(KPI_RATE_DTO, response.getBody());
        verify(kpiRateAdapterService, times(1)).findById(KPI_RATE_ID);
        verifyNoMoreInteractions(kpiRateAdapterService);
    }

    @Test
    @Order(3)
    @DisplayName("Update kpi rate")
    public void updateEmployeeTest() {
        when(kpiRateAdapterService.update(any(), any())).thenReturn(KPI_RATE_ID);
        var response = kpiRateController.updateKpiRate(KPI_RATE_REQUEST, KPI_RATE_ID, mock(BindingResult.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(KPI_RATE_ID, response.getBody());
        verify(kpiRateAdapterService, times(1)).update(KPI_RATE_REQUEST, KPI_RATE_ID);
        verifyNoMoreInteractions(kpiRateAdapterService);
    }

    @Test
    @Order(4)
    @DisplayName("Delete kpi rate")
    public void deleteEmployeeTest() {
        var response = kpiRateController.deleteKpiRate(KPI_RATE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(kpiRateAdapterService, times(1)).delete(KPI_RATE_ID);
        verifyNoMoreInteractions(kpiRateAdapterService);
    }

}