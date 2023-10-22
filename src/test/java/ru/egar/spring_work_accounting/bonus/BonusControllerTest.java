package ru.egar.spring_work_accounting.bonus;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.BONUS_ID;
import static ru.egar.spring_work_accounting.util.TestModels.BONUS_DTO;
import static ru.egar.spring_work_accounting.util.TestModels.BONUS_REQUEST;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BonusControllerTest {

    @Mock
    private BonusAdapterService bonusAdapterService;

    @InjectMocks
    private BonusController bonusController;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find bonus by id")
    void findBonusByIdTest() {
        when(bonusAdapterService.findById(any())).thenReturn(BONUS_DTO);
        var response = bonusController.findBonusById(BONUS_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(BONUS_DTO, response.getBody());
        verify(bonusAdapterService, times(1)).findById(BONUS_ID);
        verifyNoMoreInteractions(bonusAdapterService);
    }

    @Test
    @Order(2)
    @DisplayName("Save bonus")
    void saveBonusTest() {
        when(bonusAdapterService.save(any())).thenReturn(BONUS_ID);
        var response = bonusController.saveBonus(BONUS_REQUEST, mock(BindingResult.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(BONUS_ID, response.getBody());
        verify(bonusAdapterService, times(1)).save(BONUS_REQUEST);
        verifyNoMoreInteractions(bonusAdapterService);
    }

    @Test
    @Order(3)
    @DisplayName("Update bonus")
    void updateBonusTest() {
        when(bonusAdapterService.update(any(), any())).thenReturn(BONUS_ID);
        var response = bonusController.updateBonus(BONUS_REQUEST, BONUS_ID, mock(BindingResult.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(BONUS_ID, response.getBody());
        verify(bonusAdapterService, times(1)).update(BONUS_REQUEST, BONUS_ID);
        verifyNoMoreInteractions(bonusAdapterService);
    }

    @Test
    @Order(4)
    @DisplayName("Delete bonus")
    void deleteBonusTest() {
        var response = bonusController.deleteBonus(BONUS_ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(bonusAdapterService, times(1)).delete(BONUS_ID);
        verifyNoMoreInteractions(bonusAdapterService);
    }

}