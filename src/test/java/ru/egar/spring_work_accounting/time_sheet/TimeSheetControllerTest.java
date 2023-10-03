package ru.egar.spring_work_accounting.time_sheet;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TIME_SHEET_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TimeSheetControllerTest {

    @Mock
    private TimeSheetAdapterService timeSheetAdapterService;

    @InjectMocks
    private TimeSheetController timeSheetController;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Create time sheet")
    public void createTimeSheetTest() {
        when(timeSheetAdapterService.save(TIME_SHEET_REQUEST)).thenReturn(TIME_SHEET_ID);
        var response = timeSheetController.createTimeSheet(TIME_SHEET_REQUEST);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(TIME_SHEET_ID, response.getBody());
        verify(timeSheetAdapterService, times(1)).save(TIME_SHEET_REQUEST);
        verifyNoMoreInteractions(timeSheetAdapterService);
    }

    @Test
    @Order(2)
    @DisplayName("Find time sheet by id")
    public void findTimeSheetByIdTest() {
        when(timeSheetAdapterService.findById(TIME_SHEET_ID)).thenReturn(TIME_SHEET_RESPONSE);
        var response = timeSheetController.findTimeSheetById(TIME_SHEET_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TIME_SHEET_RESPONSE, response.getBody());
        verify(timeSheetAdapterService, times(1)).findById(TIME_SHEET_ID);
        verifyNoMoreInteractions(timeSheetAdapterService);
    }

    @Test
    @Order(3)
    @DisplayName("Update time sheet")
    public void updateTimeSheetTest() {
        when(timeSheetAdapterService.update(TIME_SHEET_REQUEST, TIME_SHEET_ID)).thenReturn(TIME_SHEET_ID);
        var response = timeSheetController.updateTimeSheet(TIME_SHEET_REQUEST, TIME_SHEET_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TIME_SHEET_ID, response.getBody());
        verify(timeSheetAdapterService, times(1)).update(TIME_SHEET_REQUEST, TIME_SHEET_ID);
        verifyNoMoreInteractions(timeSheetAdapterService);
    }

    @Test
    @Order(4)
    @DisplayName("Delete time sheet")
    public void deleteTimeSheetTest() {
        var response = timeSheetController.deleteTimeSheet(TIME_SHEET_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(timeSheetAdapterService, times(1)).delete(TIME_SHEET_ID);
        verifyNoMoreInteractions(timeSheetAdapterService);
    }

    @Test
    @Order(5)
    @DisplayName("Handle TimeSheetNotFoundException")
    public void handleTaskNotFoundExceptionTest() {
        TimeSheetNotFoundException exception = new TimeSheetNotFoundException();
        var response = timeSheetController.handleTaskNotFoundException(exception);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(exception.getMessage(), response.getBody().getMessage());
    }

}