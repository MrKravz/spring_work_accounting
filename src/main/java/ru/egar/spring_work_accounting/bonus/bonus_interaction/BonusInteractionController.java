package ru.egar.spring_work_accounting.bonus.bonus_interaction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("totals")
@RequiredArgsConstructor
public class BonusInteractionController {

    private final BonusInteractionService bonusInteractionService;

    @PatchMapping("set_bonus")
    private ResponseEntity<HttpStatus> setBonus(@RequestBody BonusInteractionRequest bonusInteractionRequest) {
        bonusInteractionService.setBonus(bonusInteractionRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("delete_bonus")
    private ResponseEntity<HttpStatus> deleteBonus(@RequestBody BonusInteractionRequest bonusInteractionRequest) {
        bonusInteractionService.deleteBonus(bonusInteractionRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
