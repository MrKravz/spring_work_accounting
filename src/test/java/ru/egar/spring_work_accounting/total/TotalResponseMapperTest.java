package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.TOTAL;
import static ru.egar.spring_work_accounting.util.TestModels.TOTAL_DTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TotalResponseMapperTest {

    @Mock
    private EmployeeDtoMapper employeeDtoMapper;

    @InjectMocks
    private TotalDtoMapperImpl totalDtoMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to response")
    public void mapTest() {
        var result = totalDtoMapper.map(TOTAL);
        assertEquals(TOTAL_DTO.getId(), result.getId());
        assertEquals(TOTAL_DTO.getTotalSalary(), result.getTotalSalary());
        assertEquals(TOTAL_DTO.getTotalWorkedTime(), result.getTotalWorkedTime());
        assertEquals(TOTAL_DTO.getKpiPercentage(), result.getKpiPercentage());
    }

}