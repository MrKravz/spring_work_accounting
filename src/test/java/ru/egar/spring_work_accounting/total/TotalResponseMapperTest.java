package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.TOTAL;
import static ru.egar.spring_work_accounting.util.TestModels.TOTAL_RESPONSE;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TotalResponseMapperTest {

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
        var result = totalResponseMapper.map(TOTAL);
        assertEquals(TOTAL_RESPONSE.getId(), result.getId());
        assertEquals(TOTAL_RESPONSE.getTotalSalary(), result.getTotalSalary());
        assertEquals(TOTAL_RESPONSE.getTotalWorkedTime(), result.getTotalWorkedTime());
        assertEquals(TOTAL_RESPONSE.getKpiPercentage(), result.getKpiPercentage());
    }

}