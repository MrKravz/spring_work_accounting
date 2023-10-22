package ru.egar.spring_work_accounting.task;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskDtoMapperTest {

    @InjectMocks
    private TaskDtoMapperImpl taskDtoMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Map to dto")
    public void mapTest() {
        var result = taskDtoMapper.map(FINISHED_TASK);
        assertEquals(TASK_DTO.getId(), result.getId());
        assertEquals(TASK_DTO.getShortName(), result.getShortName());
        assertEquals(TASK_DTO.getDescription(), result.getDescription());
        assertEquals(TASK_DTO.getDateTimeStart(), result.getDateTimeStart());
        assertEquals(TASK_DTO.getDateTimeEnd(), result.getDateTimeEnd());
        assertEquals(TASK_DTO.getTaskPointsNumber(), result.getTaskPointsNumber());
    }

    @Test
    @Order(2)
    @DisplayName("Remap to entity")
    public void remapTest() {
        var result = taskDtoMapper.remap(TASK_DTO);
        assertEquals(FINISHED_TASK.getId(), result.getId());
        assertEquals(FINISHED_TASK.getShortName(), result.getShortName());
        assertEquals(FINISHED_TASK.getDescription(), result.getDescription());
        assertEquals(FINISHED_TASK.getDateTimeStart(), result.getDateTimeStart());
        assertEquals(FINISHED_TASK.getDateTimeEnd(), result.getDateTimeEnd());
        assertEquals(FINISHED_TASK.getTaskPointsNumber(), result.getTaskPointsNumber());
    }

}
