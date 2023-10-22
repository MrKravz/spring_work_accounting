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
    @DisplayName("Map to entity")
    public void mapTest() {
        var result = taskRequestMapper.map(TASK_REQUEST);
        assertEquals(FINISHED_TASK.getShortName(), result.getShortName());
        assertEquals(FINISHED_TASK.getDescription(), result.getDescription());
        assertEquals(FINISHED_TASK.getDateTimeStart(), result.getDateTimeStart());
        assertEquals(FINISHED_TASK.getDateTimeEnd(), result.getDateTimeEnd());
        assertEquals(FINISHED_TASK.getTaskPointsNumber(), result.getTaskPointsNumber());
    }

}
