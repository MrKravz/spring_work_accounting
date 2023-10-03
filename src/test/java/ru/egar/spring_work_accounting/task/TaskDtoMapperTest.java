package ru.egar.spring_work_accounting.task;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskDtoMapperTest {

    @Mock
    private EmployeeDtoMapper employeeDtoMapper;

    @InjectMocks
    private TaskDtoMapperImpl taskDtoMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName(value = "Map to dto")
    public void mapTest() {
        var result = taskDtoMapper.map(TASK);
        assertEquals(TASK_DTO.getId(), result.getId());
        assertEquals(TASK_DTO.getShortName(), result.getShortName());
        assertEquals(TASK_DTO.getDescription(), result.getDescription());
        assertEquals(TASK_DTO.getDateTimeStart(), result.getDateTimeStart());
        assertEquals(TASK_DTO.getDateTimeEnd(), result.getDateTimeEnd());
        assertEquals(TASK_DTO.getTaskPointsNumber(), result.getTaskPointsNumber());
        assertEquals(TASK_DTO.getTaskStatus(), result.getTaskStatus());
    }

    @Test
    @Order(2)
    @DisplayName(value = "Remap to entity")
    public void remapTest() {
        var result = taskDtoMapper.remap(TASK_DTO);
        assertEquals(TASK.getId(), result.getId());
        assertEquals(TASK.getShortName(), result.getShortName());
        assertEquals(TASK.getDescription(), result.getDescription());
        assertEquals(TASK.getDateTimeStart(), result.getDateTimeStart());
        assertEquals(TASK.getDateTimeEnd(), result.getDateTimeEnd());
        assertEquals(TASK.getTaskPointsNumber(), result.getTaskPointsNumber());
        assertEquals(TASK.getTaskStatus(), result.getTaskStatus());
    }

}
