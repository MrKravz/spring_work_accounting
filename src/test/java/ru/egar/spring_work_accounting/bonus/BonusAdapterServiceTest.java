package ru.egar.spring_work_accounting.bonus;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.BONUS_ID;
import static ru.egar.spring_work_accounting.util.TestConstants.EMPLOYEE_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BonusAdapterServiceTest {

    @Mock
    private BonusService bonusService;
    @Mock
    private BonusRequestMapper bonusRequestMapper;
    @Mock
    private BonusDtoMapper bonusDtoMapper;

    @InjectMocks
    private BonusAdapterService bonusAdapterService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find bonus by id")
    void findByIdTest() {
        when(bonusService.findById(any())).thenReturn(BONUS);
        when(bonusDtoMapper.map(any())).thenReturn(BONUS_DTO);
        var result = bonusAdapterService.findById(BONUS_ID);
        verify(bonusService, times(1)).findById(BONUS_ID);
        verify(bonusDtoMapper, times(1)).map(BONUS);
        assertEquals(BONUS_DTO, result);
    }

    @Test
    @Order(2)
    @DisplayName("Save bonus")
    void saveTest() {
        when(bonusService.save(any())).thenReturn(BONUS_ID);
        when(bonusRequestMapper.map(any())).thenReturn(BONUS);
        var result = bonusAdapterService.save(BONUS_REQUEST);
        verify(bonusService, times(1)).save(BONUS);
        verify(bonusRequestMapper, times(1)).map(BONUS_REQUEST);
        assertEquals(BONUS_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Update bonus")
    void updateTest() {
        when(bonusService.update(any(), any())).thenReturn(BONUS_ID);
        when(bonusRequestMapper.map(any())).thenReturn(BONUS);
        var result = bonusAdapterService.update(BONUS_REQUEST, BONUS_ID);
        verify(bonusService, times(1)).update(BONUS, BONUS_ID);
        verify(bonusRequestMapper, times(1)).map(BONUS_REQUEST);
        assertEquals(BONUS_ID, result);

    }

    @Test
    @Order(4)
    @DisplayName("Delete bonus")
    void deleteTest() {
        bonusAdapterService.delete(EMPLOYEE_ID);
        verify(bonusService).delete(EMPLOYEE_ID);
    }

}