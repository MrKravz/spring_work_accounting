package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.KPI_RATE;
import static ru.egar.spring_work_accounting.util.TestModels.KPI_RATE_REQUEST;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KpiRateRequestMapperTest {

    @InjectMocks
    private KpiRateRequestMapperImpl kpiRateRequestMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to entity")
    public void mapTest() {
        var result = kpiRateRequestMapper.map(KPI_RATE_REQUEST);
        assertEquals(KPI_RATE.getAgreedSalary(), result.getAgreedSalary());
        assertEquals(KPI_RATE.getAgreedTasksPointQuantity(), result.getAgreedTasksPointQuantity());
        assertEquals(KPI_RATE.getPosition(), result.getPosition());
        assertEquals(KPI_RATE.getGrade(), result.getGrade());
    }

}
