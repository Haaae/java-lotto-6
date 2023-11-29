package lotto.domain.entity;

import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.utils.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers, ExceptionCode.INVALID_LOTTO_NUMBER);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers, ExceptionCode e) {
        Validator.isOverSize(numbers, 6, e);
        Validator.isDuplication(numbers, e);
        numbers.forEach(number -> Validator.isValidRange(number, 45, 1, e));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int calculateMatchCount(final Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }
}
