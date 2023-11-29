package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.entity.Lotto;
import lotto.exception.ExceptionCode;
import lotto.utils.validator.Validator;

public class LottoGenerator {

    public Lotto generate() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .toList(), ExceptionCode.INVALID_LOTTO_NUMBER
        );
    }

    public List<Lotto> generate(final long purchasePrice) {
        long priceOfLotto = 1000L;
        Validator.isNoRemainder(purchasePrice, priceOfLotto, ExceptionCode.INVALID_PURCHASE_PRICE);
        Validator.isNegative(purchasePrice, ExceptionCode.INVALID_PURCHASE_PRICE);

        long countOfLotto = purchasePrice / priceOfLotto;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(generate());
        }
        return lottos;
    }
}
