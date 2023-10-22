package ru.egar.spring_work_accounting.time_sheet;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TIME_SHEET_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TimeSheetAdapterServiceTest {

    @Mock
    private TimeSheetService timeSheetService;

    @Mock
    private TimeSheetRequestMapper timeSheetRequestMapper;

    @Mock
    private TimeSheetDtoMapper timeSheetDtoMapper;

    @InjectMocks
    private TimeSheetAdapterService timeSheetAdapterService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find employee by id")
    void findByIdTest() {
        when(timeSheetService.findById(any())).thenReturn(TIME_SHEET);
        when(timeSheetDtoMapper.map(any())).thenReturn(TIME_SHEET_DTO);
        var result = timeSheetAdapterService.findById(TIME_SHEET_ID);
        verify(timeSheetService, times(1)).findById(TIME_SHEET_ID);
        verify(timeSheetDtoMapper, times(1)).map(TIME_SHEET);
        assertEquals(TIME_SHEET_DTO, result);
    }

    @Test
    @Order(2)
    @DisplayName("Update employee")
    void updateTest() {
        when(timeSheetService.update(any(), any())).thenReturn(TIME_SHEET_ID);
        when(timeSheetRequestMapper.map(any())).thenReturn(TIME_SHEET);
        var result = timeSheetAdapterService.update(TIME_SHEET_REQUEST, TIME_SHEET_ID);
        verify(timeSheetRequestMapper, times(1)).map(TIME_SHEET_REQUEST);
        verify(timeSheetService, times(1)).update(TIME_SHEET, TIME_SHEET_ID);
        assertEquals(TIME_SHEET_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Save employee")
    void saveTest() {
        when(timeSheetService.save(any())).thenReturn(TIME_SHEET_ID);
        when(timeSheetRequestMapper.map(any())).thenReturn(TIME_SHEET);
        var result = timeSheetAdapterService.save(TIME_SHEET_REQUEST);
        verify(timeSheetRequestMapper, times(1)).map(TIME_SHEET_REQUEST);
        verify(timeSheetService, times(1)).save(TIME_SHEET);
        assertEquals(TIME_SHEET_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Delete employee by id")
    void deleteTest() {
        timeSheetAdapterService.delete(TIME_SHEET_ID);
        verify(timeSheetService).delete(TIME_SHEET_ID);
    }

}