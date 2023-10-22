package ru.egar.spring_work_accounting.time_sheet;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TIME_SHEET_ID;
import static ru.egar.spring_work_accounting.util.TestModels.TIME_SHEET;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TimeSheetServiceTest {

    @Mock
    private TimeSheetRepository timeSheetRepository;

    @InjectMocks
    private TimeSheetService timeSheetService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find employee by id")
    void findByIdTest() {
        when(timeSheetRepository.findById(any())).thenReturn(Optional.ofNullable(TIME_SHEET));
        var result = timeSheetService.findById(TIME_SHEET_ID);
        verify(timeSheetRepository, times(1)).findById(TIME_SHEET_ID);
        assertEquals(TIME_SHEET, result);
    }

    @Test
    @Order(2)
    @DisplayName("Update employee")
    void updateTest() {
        when(timeSheetRepository.findById(any())).thenReturn(Optional.ofNullable(TIME_SHEET));
        when(timeSheetRepository.save(any())).thenReturn(TIME_SHEET);
        var result = timeSheetService.update(TIME_SHEET, TIME_SHEET_ID);
        verify(timeSheetRepository, times(1)).findById(TIME_SHEET_ID);
        verify(timeSheetRepository, times(1)).save(TIME_SHEET);
        assertEquals(TIME_SHEET_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Save employee")
    void saveTest() {
        when(timeSheetRepository.save(any())).thenReturn(TIME_SHEET);
        var result = timeSheetService.save(TIME_SHEET);
        verify(timeSheetRepository, times(1)).save(TIME_SHEET);
        assertEquals(TIME_SHEET_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Delete employee by id")
    void deleteTest() {
        timeSheetService.delete(TIME_SHEET_ID);
        verify(timeSheetRepository).deleteById(TIME_SHEET_ID);
    }

}