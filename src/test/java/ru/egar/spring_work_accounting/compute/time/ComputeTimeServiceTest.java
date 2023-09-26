package ru.egar.spring_work_accounting.compute.time;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputeTimeServiceTest {

    @Mock
    private TimeSheetRepository timeSheetRepository;

    @InjectMocks
    private ComputeTimeService computeTimeService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    void computeTimeTest() {
        when(timeSheetRepository.findAllByEmployeeAndDateBetween(any(), any(), any())).thenReturn(TIME_SHEETS);
        var result = computeTimeService.computeTime(EMPLOYEE, TIME_STATUS_TURNOUT ,DATE_START, DATE_END);
        verify(timeSheetRepository, times(1)).findAllByEmployeeAndDateBetween(any(), any(), any());
        assertEquals(EXPECTED_TIME, result);
    }

}