package ru.egar.spring_work_accounting.time_sheet;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.TIME_SHEET;
import static ru.egar.spring_work_accounting.util.TestModels.TIME_SHEET_DTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeSheetDtoMapperTest {

    @Mock
    private EmployeeDtoMapper employeeDtoMapper;

    @InjectMocks
    private TimeSheetDtoMapperImpl timeSheetDtoMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to dto")
    public void mapTest() {
        var result = timeSheetDtoMapper.map(TIME_SHEET);
        assertEquals(TIME_SHEET_DTO.getId(), result.getId());
        assertEquals(TIME_SHEET_DTO.getTimeSpan(), result.getTimeSpan());
        assertEquals(TIME_SHEET_DTO.getTimeStatus(), result.getTimeStatus());
        assertEquals(TIME_SHEET_DTO.getDate(), result.getDate());
    }

    @Test
    @Order(2)
    @DisplayName(value = "Remap to entity")
    public void remapTest() {
        var result = timeSheetDtoMapper.remap(TIME_SHEET_DTO);
        assertEquals(TIME_SHEET.getId(), result.getId());
        assertEquals(TIME_SHEET.getTimeSpan(), result.getTimeSpan());
        assertEquals(TIME_SHEET.getTimeStatus(), result.getTimeStatus());
        assertEquals(TIME_SHEET.getDate(), result.getDate());
    }

}
