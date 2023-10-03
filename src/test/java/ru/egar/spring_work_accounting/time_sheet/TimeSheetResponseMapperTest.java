package ru.egar.spring_work_accounting.time_sheet;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;
import ru.egar.spring_work_accounting.total.TotalResponseMapperImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;
import static ru.egar.spring_work_accounting.util.TestModels.TOTAL_RESPONSE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeSheetResponseMapperTest {
    @Mock
    private EmployeeDtoMapper employeeDtoMapper;

    @InjectMocks
    private TotalResponseMapperImpl totalResponseMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to response")
    public void mapTest() {
        when(employeeDtoMapper.map(any())).thenReturn(EMPLOYEE_DTO);
        var result = totalResponseMapper.map(TOTAL);
        verify(employeeDtoMapper, times(1)).map(EMPLOYEE);
        assertEquals(TOTAL_RESPONSE.getId(), result.getId());
        assertEquals(TOTAL_RESPONSE.getTotalSalary(), result.getTotalSalary());
        assertEquals(TOTAL_RESPONSE.getTotalWorkedTime(), result.getTotalWorkedTime());
        assertEquals(TOTAL_RESPONSE.getKpiPercentage(), result.getKpiPercentage());
    }
}
