package ru.egar.spring_work_accounting.bonus;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static ru.egar.spring_work_accounting.util.TestConstants.BONUS_ID;
import static ru.egar.spring_work_accounting.util.TestModels.BONUS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BonusServiceTest {

    @Mock
    private BonusRepository bonusRepository;

    @InjectMocks
    private BonusService bonusService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    @Order(1)
    @DisplayName("Find bonus by id")
    void findByIdTest() {
        when(bonusRepository.findById(any())).thenReturn(Optional.ofNullable(BONUS));
        var result = bonusService.findById(BONUS_ID);
        verify(bonusRepository, times(1)).findById(BONUS_ID);
        assertEquals(BONUS, result);
    }

    @Test
    @Order(2)
    @DisplayName("Save bonus")
    void saveTest() {
        when(bonusRepository.save(any())).thenReturn(BONUS);
        var result = bonusService.save(BONUS);
        verify(bonusRepository, times(1)).save(BONUS);
        assertEquals(BONUS_ID, result);
    }

    @Test
    @Order(3)
    @DisplayName("Update bonus")
    void updateTest() {
        when(bonusRepository.findById(any())).thenReturn(Optional.ofNullable(BONUS));
        when(bonusRepository.save(any())).thenReturn(BONUS);
        var result = bonusService.update(BONUS, BONUS_ID);
        verify(bonusRepository, times(1)).findById(BONUS_ID);
        verify(bonusRepository, times(1)).save(BONUS);
        assertEquals(BONUS_ID, result);
    }

    @Test
    @Order(4)
    @DisplayName("Delete bonus")
    void deleteTest() {
        when(bonusRepository.findById(any())).thenReturn(Optional.ofNullable(BONUS));
        when(bonusRepository.save(any())).thenReturn(BONUS);
        bonusService.delete(BONUS_ID);
        verify(bonusRepository, times(1)).findById(BONUS_ID);
        verify(bonusRepository, times(1)).save(BONUS);
    }

}