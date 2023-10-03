package ru.egar.spring_work_accounting.task;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskRequestMapperTest {

    @Mock
    private EmployeeDtoMapper employeeDtoMapper;

    @InjectMocks
    private TaskRequestMapperImpl taskRequestMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to entity")
    public void mapTest() {
        var result = taskRequestMapper.map(TASK_REQUEST);
        assertEquals(TASK.getShortName(), result.getShortName());
        assertEquals(TASK.getDescription(), result.getDescription());
        assertEquals(TASK.getDateTimeStart(), result.getDateTimeStart());
        assertEquals(TASK.getDateTimeEnd(), result.getDateTimeEnd());
        assertEquals(TASK.getTaskPointsNumber(), result.getTaskPointsNumber());
    }

}
