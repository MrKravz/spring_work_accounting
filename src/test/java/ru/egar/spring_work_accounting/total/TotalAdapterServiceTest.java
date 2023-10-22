package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TOTAL_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TotalAdapterServiceTest {

    @Mock
    private TotalService totalService;

    @Mock
    private TotalDtoMapper totalDtoMapper;

    @InjectMocks
    private TotalAdapterService totalAdapterService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find total by id")
    void findByIdTest() {
        when(totalService.findById(any())).thenReturn(TOTAL);
        when(totalDtoMapper.map(any())).thenReturn(TOTAL_DTO);
        var result = totalAdapterService.findById(TOTAL_ID);
        verify(totalService, times(1)).findById(TOTAL_ID);
        verify(totalDtoMapper, times(1)).map(TOTAL);
        assertEquals(TOTAL_DTO, result);
    }

    @Test
    @Order(2)
    @DisplayName("Generate total")
    void generateTotalTest() {
        when(totalService.generateTotal(any())).thenReturn(TOTAL_ID);
        var result = totalAdapterService.generateTotal(GENERATE_TOTAL_REQUEST);
        verify(totalService, times(1)).generateTotal(GENERATE_TOTAL_REQUEST);
        assertEquals(TOTAL_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Delete total")
    void deleteTest() {
        totalAdapterService.delete(TOTAL_ID);
        verify(totalService, times(1)).delete(TOTAL_ID);
    }

}