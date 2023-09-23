package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.*;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE;
import static ru.egar.spring_work_accounting.util.TestModels.TIME_SHEETS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComputeTimeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private TimeSheetRepository timeSheetRepository;

    @InjectMocks
    private ComputeTimeService computeTimeService;


    @BeforeEach
    public void setUp(){
        openMocks(this);
    }

    @Test
    @Order(1)
    public void computeTimeTest() {
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(EMPLOYEE));
        when(timeSheetRepository.findAllByEmployeeAndDateBetween(any(), any(), any())).thenReturn(TIME_SHEETS);
        var result = computeTimeService.computeTime(EMPLOYEE, TIME_STATUS_TURNOUT, DATE_START, DATE_END);
        verify(employeeRepository, times(1)).findById(EMPLOYEE_ID);
        verify(timeSheetRepository, times(1)).findAllByEmployeeAndDateBetween(EMPLOYEE, DATE_START, DATE_END);
        assertEquals(EXPECTED_TIME, result);
    }
}
