package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TOTAL_ID;
import static ru.egar.spring_work_accounting.util.TestModels.GENERATE_TOTAL_REQUEST;
import static ru.egar.spring_work_accounting.util.TestModels.TOTAL_DTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TotalControllerTest {

    @Mock
    private TotalAdapterService totalAdapterService;

    @InjectMocks
    private TotalController totalController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find total by id")
    void findTotalByIdTest() {
        when(totalAdapterService.findById(any())).thenReturn(TOTAL_DTO);
        var response = totalController.findTotalById(TOTAL_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(TOTAL_DTO, response.getBody());
        verify(totalAdapterService, times(1)).findById(TOTAL_ID);
        verifyNoMoreInteractions(totalAdapterService);
    }

    @Test
    @Order(2)
    @DisplayName("Create total")
    void createTotalTest() {
        when(totalAdapterService.generateTotal(any())).thenReturn(TOTAL_ID);
        var response = totalController.createTotal(GENERATE_TOTAL_REQUEST);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(TOTAL_ID, response.getBody());
        verify(totalAdapterService, times(1)).generateTotal(GENERATE_TOTAL_REQUEST);
        verifyNoMoreInteractions(totalAdapterService);
    }

    @Test
    @Order(3)
    @DisplayName("Delete total")
    void deleteTotalTest() {
        var response = totalController.deleteTotal(TOTAL_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(totalAdapterService, times(1)).delete(TOTAL_ID);
        verifyNoMoreInteractions(totalAdapterService);
    }

}