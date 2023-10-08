package ru.egar.spring_work_accounting.time_sheet;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeSheetRequestMapperTest { // TODO fix test

    @Mock
    private EmployeeDtoMapper employeeDtoMapper;

    @InjectMocks
    private TimeSheetRequestMapperImpl timeSheetRequestMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to entity")
    public void mapTest() {
        var result = timeSheetRequestMapper.map(TIME_SHEET_REQUEST);
        assertEquals(TIME_SHEET.getTimeSpan(), result.getTimeSpan());
        assertEquals(TIME_SHEET.getTimeStatus(), result.getTimeStatus());
        assertEquals(TIME_SHEET.getDate(), result.getDate());
    }

}
