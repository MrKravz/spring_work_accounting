package ru.egar.spring_work_accounting.task;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskResponseMapperTest {

    @Mock
    private EmployeeDtoMapper employeeDtoMapper;

    @InjectMocks
    private TaskResponseMapperImpl taskResponseMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to response")
    public void mapTest() {
        var result = taskResponseMapper.map(TASK);
        assertEquals(TASK_RESPONSE.getId(), result.getId());
        assertEquals(TASK_RESPONSE.getShortName(), result.getShortName());
        assertEquals(TASK_RESPONSE.getDescription(), result.getDescription());
        assertEquals(TASK_RESPONSE.getDateTimeStart(), result.getDateTimeStart());
        assertEquals(TASK_RESPONSE.getDateTimeEnd(), result.getDateTimeEnd());
        assertEquals(TASK_RESPONSE.getTaskPointsNumber(), result.getTaskPointsNumber());
        assertEquals(TASK_RESPONSE.getTaskStatus(), result.getTaskStatus());
    }

}