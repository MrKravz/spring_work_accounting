package ru.egar.spring_work_accounting.bonus.bonus_interaction;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestModels.BONUS_INTERACTION_REQUEST;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BonusInteractionControllerTest {

    @Mock
    private BonusInteractionService bonusInteractionService;

    @InjectMocks
    private BonusInteractionController bonusInteractionController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Set bonus")
    void setBonus() {
        var response = bonusInteractionController.setBonus(BONUS_INTERACTION_REQUEST);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(bonusInteractionService, times(1)).setBonus(BONUS_INTERACTION_REQUEST);
        verifyNoMoreInteractions(bonusInteractionService);
    }

    @Test
    @Order(2)
    @DisplayName("Delete bonus")
    void deleteBonus() {
        var response = bonusInteractionController.deleteBonus(BONUS_INTERACTION_REQUEST);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(bonusInteractionService, times(1)).deleteBonus(BONUS_INTERACTION_REQUEST);
        verifyNoMoreInteractions(bonusInteractionService);
    }

}