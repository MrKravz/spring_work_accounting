package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.KPI_RATE;
import static ru.egar.spring_work_accounting.util.TestModels.KPI_RATE_DTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KpiRateDtoMapperTest {

    @InjectMocks
    private KpiRateDtoMapperImpl kpiRateDtoMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to dto")
    public void mapTest() {
        var result = kpiRateDtoMapper.map(KPI_RATE);
        assertEquals(KPI_RATE_DTO.getId(), result.getId());
        assertEquals(KPI_RATE_DTO.getAgreedSalary(), result.getAgreedSalary());
        assertEquals(KPI_RATE_DTO.getAgreedTasksPointQuantity(), result.getAgreedTasksPointQuantity());
    }

    @Test
    @Order(2)
    @DisplayName(value = "Remap to entity")
    public void remapTest() {
        var result = kpiRateDtoMapper.remap(KPI_RATE_DTO);
        assertEquals(KPI_RATE.getId(), result.getId());
        assertEquals(KPI_RATE.getAgreedSalary(), result.getAgreedSalary());
        assertEquals(KPI_RATE.getAgreedTasksPointQuantity(), result.getAgreedTasksPointQuantity());
    }

}
