package ru.egar.spring_work_accounting.employee;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateDtoMapper;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDtoMapperTest {

    @Mock
    private HourRateDtoMapper hourRateDtoMapper;

    @Mock
    private KpiRateDtoMapper kpiRateDtoMapper;

    @InjectMocks
    private EmployeeDtoMapperImpl employeeDtoMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to dto")
    public void mapTest() {
        var result = employeeDtoMapper.map(EMPLOYEE);
        assertEquals(EMPLOYEE_DTO.getId(), result.getId());
        assertEquals(EMPLOYEE_DTO.getName(), result.getName());
        assertEquals(EMPLOYEE_DTO.getDateOfBirthDay(), result.getDateOfBirthDay());
        assertEquals(EMPLOYEE_DTO.getPaymentSystem(), result.getPaymentSystem());
    }

    @Test
    @Order(2)
    @DisplayName(value = "Remap to entity")
    public void remapTest() {
        var result = employeeDtoMapper.remap(EMPLOYEE_DTO);
        assertEquals(EMPLOYEE.getId(), result.getId());
        assertEquals(EMPLOYEE.getName(), result.getName());
        assertEquals(EMPLOYEE.getDateOfBirthDay(), result.getDateOfBirthDay());
        assertEquals(EMPLOYEE.getPaymentSystem(), result.getPaymentSystem());
    }

}
