package lotto.domain;

import java.util.List;
import lotto.domain.entity.Lotto;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
