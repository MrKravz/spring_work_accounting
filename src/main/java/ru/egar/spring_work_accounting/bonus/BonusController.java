package ru.egar.spring_work_accounting.bonus;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bonuses")
@RequiredArgsConstructor
public class BonusController {

    private final BonusAdapterService bonusAdapterService;

    @GetMapping("{id}")
    public ResponseEntity<BonusDto> findBonusById(@PathVariable Long id) {
        return new ResponseEntity<>(bonusAdapterService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveBonus(@RequestBody BonusRequest bonusRequest,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new BonusNotCreatedException(errorMessage.toString());
        }
        return new ResponseEntity<>(bonusAdapterService.save(bonusRequest), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Long> updateBonus(@RequestBody BonusRequest bonusRequest,
                                       @PathVariable Long id,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new BonusNotUpdatedException(errorMessage.toString());
        }
        return new ResponseEntity<>(bonusAdapterService.update(bonusRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBonus(@PathVariable Long id) {
        bonusAdapterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
