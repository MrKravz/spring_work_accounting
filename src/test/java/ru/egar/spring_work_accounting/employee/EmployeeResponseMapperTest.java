package ru.egar.spring_work_accounting.employee;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateDtoMapper;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateDtoMapper;
import ru.egar.spring_work_accounting.task.TaskDtoMapper;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetDtoMapper;
import ru.egar.spring_work_accounting.total.TotalDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeResponseMapperTest {

    @Mock
    private HourRateDtoMapper hourRateDtoMapper;

    @Mock
    private KpiRateDtoMapper kpiRateDtoMapper;

    @Mock
    private TimeSheetDtoMapper timeSheetDtoMapper;

    @Mock
    private TaskDtoMapper taskDtoMapper;

    @Mock
    private TotalDtoMapper totalDtoMapper;

    @InjectMocks
    private EmployeeResponseMapperImpl employeeResponseMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to response")
    public void mapTest() {
        var result = employeeResponseMapper.map(EMPLOYEE);
        assertEquals(EMPLOYEE_RESPONSE.getId(), result.getId());
        assertEquals(EMPLOYEE_RESPONSE.getName(), result.getName());
        assertEquals(EMPLOYEE_RESPONSE.getDateOfBirthDay(), result.getDateOfBirthDay());
        assertEquals(EMPLOYEE_RESPONSE.getEmployeePosition(), result.getEmployeePosition());
        assertEquals(EMPLOYEE_RESPONSE.getEmployeeGrade(), result.getEmployeeGrade());
        assertEquals(EMPLOYEE_RESPONSE.getPaymentSystem(), result.getPaymentSystem());
        assertEquals(EMPLOYEE_RESPONSE.getHourRate(), result.getHourRate());
        assertEquals(EMPLOYEE_RESPONSE.getKpiRate(), result.getKpiRate());
    }

}
