package lotto.domain.entity;

import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.utils.validator.Validator;

public class BonusNumber extends Entity {

    private final long id;
    private final int number;

    public BonusNumber(final int number, final Lotto winningNumbers) {
        validate(number, winningNumbers.getNumbers(), ExceptionCode.INVALID_BONUS_NUMBER);
        this.number = number;
        this.id = getNextId();
    }

    private void validate(final int number, final List<Integer> numbers, final ExceptionCode e) {
        Validator.notContains(numbers, number, e);
        Validator.isValidRange(number, 45, 1, e);
    }

    @Override
    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
}
