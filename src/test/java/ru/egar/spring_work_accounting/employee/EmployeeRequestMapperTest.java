package ru.egar.spring_work_accounting.employee;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE;
import static ru.egar.spring_work_accounting.util.TestModels.EMPLOYEE_REQUEST;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRequestMapperTest {

    @InjectMocks
    private EmployeeRequestMapperImpl employeeRequestMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to entity")
    public void mapTest() {
        var result = employeeRequestMapper.map(EMPLOYEE_REQUEST);
        assertEquals(EMPLOYEE.getName(), result.getName());
        assertEquals(EMPLOYEE.getDateOfBirthDay(), result.getDateOfBirthDay());
        assertEquals(EMPLOYEE.getEmployeePosition(), result.getEmployeePosition());
        assertEquals(EMPLOYEE.getEmployeeGrade(), result.getEmployeeGrade());
        assertEquals(EMPLOYEE.getPaymentSystem(), result.getPaymentSystem());
    }

}
