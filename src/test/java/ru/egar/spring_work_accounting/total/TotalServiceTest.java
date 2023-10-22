package ru.egar.spring_work_accounting.total;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.TOTAL_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TotalServiceTest {

    @Mock
    private ComputeTotalService computeTotalService;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private TotalRepository totalRepository;

    @InjectMocks
    private TotalService totalService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find total by id")
    void findByIdTest() {
        when(totalRepository.findById(any())).thenReturn(Optional.ofNullable(TOTAL));
        var result = totalService.findById(TOTAL_ID);
        verify(totalRepository, times(1)).findById(TOTAL_ID);
        assertEquals(TOTAL, result);
    }

    @Test
    @Order(2)
    @DisplayName("Update total")
    void updateTest() {
        when(totalRepository.findById(any())).thenReturn(Optional.ofNullable(TOTAL));
        when(totalRepository.save(any())).thenReturn(TOTAL);
        var result = totalService.update(TOTAL, TOTAL_ID);
        verify(totalRepository, times(1)).findById(TOTAL_ID);
        verify(totalRepository, times(1)).save(TOTAL);
        assertEquals(TOTAL_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Save total")
    void saveTest() {
        when(totalRepository.save(any())).thenReturn(TOTAL);
        var result = totalService.save(TOTAL);
        verify(totalRepository, times(1)).save(TOTAL);
        assertEquals(TOTAL_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Delete total")
    void deleteTest() {
        when(totalRepository.findById(any())).thenReturn(Optional.ofNullable(TOTAL));
        when(totalRepository.save(any())).thenReturn(TOTAL);
        totalService.delete(TOTAL_ID);
        verify(totalRepository, times(1)).findById(TOTAL_ID);
        verify(totalRepository, times(1)).save(TOTAL);
    }

    @Test
    @Order(5)
    @DisplayName("Generate total")
    void generateTotalTest() {
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(EMPLOYEE));
        when(computeTotalService.computeTotal(any(), any(), any())).thenReturn(TOTAL);
        when(totalRepository.save(any())).thenReturn(TOTAL);
        var result = totalService.generateTotal(GENERATE_TOTAL_REQUEST);
        verify(employeeRepository, times(1)).findById(TOTAL_ID);
        verify(computeTotalService, times(1)).computeTotal(EMPLOYEE, LocalDate.now(), LocalDate.now());
        verify(totalRepository, times(1)).save(TOTAL);
        assertEquals(TOTAL_ID, result);
    }

}