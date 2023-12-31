package ru.egar.spring_work_accounting.rate.hour_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.HOUR_RATE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.HOUR_RATE_DTO;
import static ru.egar.spring_work_accounting.util.TestModels.HOUR_RATE_REQUEST;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HourRateControllerTest {

    @Mock
    private HourRateAdapterService hourRateAdapterService;

    @InjectMocks
    private HourRateController hourRateController;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Create hour rate")
    public void createHourRateTest() {
        when(hourRateAdapterService.save(any())).thenReturn(HOUR_RATE_ID);
        var response = hourRateController.createHourRate(HOUR_RATE_REQUEST, mock(BindingResult.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(HOUR_RATE_ID, response.getBody());
        verify(hourRateAdapterService, times(1)).save(HOUR_RATE_REQUEST);
        verifyNoMoreInteractions(hourRateAdapterService);
    }

    @Test
    @Order(2)
    @DisplayName("Find hour rate by id")
    public void findEmployeeByIdTest() {
        when(hourRateAdapterService.findById(any())).thenReturn(HOUR_RATE_DTO);
        var response = hourRateController.findHourRateById(HOUR_RATE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(HOUR_RATE_DTO, response.getBody());
        verify(hourRateAdapterService, times(1)).findById(HOUR_RATE_ID);
        verifyNoMoreInteractions(hourRateAdapterService);
    }

    @Test
    @Order(3)
    @DisplayName("Update hour rate")
    public void updateEmployeeTest() {
        when(hourRateAdapterService.update(any(), any())).thenReturn(HOUR_RATE_ID);
        var response = hourRateController.updateHourRate(HOUR_RATE_REQUEST, HOUR_RATE_ID, mock(BindingResult.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(HOUR_RATE_ID, response.getBody());
        verify(hourRateAdapterService, times(1)).update(HOUR_RATE_REQUEST, HOUR_RATE_ID);
        verifyNoMoreInteractions(hourRateAdapterService);
    }

    @Test
    @Order(4)
    @DisplayName("Delete hour rate")
    public void deleteEmployeeTest() {
        var response = hourRateController.deleteHourRate(HOUR_RATE_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(hourRateAdapterService, times(1)).delete(HOUR_RATE_ID);
        verifyNoMoreInteractions(hourRateAdapterService);
    }

}