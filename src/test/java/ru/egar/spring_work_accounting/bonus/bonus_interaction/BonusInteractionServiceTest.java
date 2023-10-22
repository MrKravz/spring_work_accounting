package ru.egar.spring_work_accounting.bonus.bonus_interaction;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.egar.spring_work_accounting.bonus.BonusService;
import ru.egar.spring_work_accounting.total.TotalService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.BONUS_ID;
import static ru.egar.spring_work_accounting.util.TestConstants.TOTAL_ID;
import static ru.egar.spring_work_accounting.util.TestModels.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BonusInteractionServiceTest {

    @Mock
    private TotalService totalService;
    @Mock
    private BonusService bonusService;

    @InjectMocks
    private BonusInteractionService bonusInteractionService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Set bonus")
    void setBonus() {
        when(totalService.findById(any())).thenReturn(TOTAL);
        when(bonusService.findById(any())).thenReturn(BONUS);
        when(totalService.update(any(), any())).thenReturn(TOTAL_ID);
        bonusInteractionService.setBonus(BONUS_INTERACTION_REQUEST);
        verify(totalService, times(1)).findById(TOTAL_ID);
        verify(bonusService, times(1)).findById(BONUS_ID);
        verify(totalService, times(1)).update(TOTAL, TOTAL_ID);
    }

    @Test
    @Order(2)
    @DisplayName("Delete bonus")
    void deleteBonus() {
        when(totalService.findById(any())).thenReturn(TOTAL);
        when(totalService.update(any(), any())).thenReturn(TOTAL_ID);
        bonusInteractionService.deleteBonus(BONUS_INTERACTION_REQUEST);
        verify(totalService, times(1)).findById(TOTAL_ID);
        verify(totalService, times(1)).update(TOTAL, TOTAL_ID);
    }

}