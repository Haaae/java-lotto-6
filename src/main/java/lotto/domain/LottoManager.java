package lotto.domain;

import java.util.Map;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.Lotto;
import lotto.service.dto.Result;

public class LottoManager {

    private static final LottoManager instance = new LottoManager();

    private LottoManager() {
    }

    public static LottoManager getInstance() {
        return instance;
    }

    public Result createResult(final LottoBundle lottoBundle, final Lotto winningNumbers, final BonusNumber bonusNumber) {
        Map<Rank, Integer> result = lottoBundle.calculateRank(winningNumbers, bonusNumber);
        float revenueRate = lottoBundle.calculateRevenueRate(getTotalPrize(result));

        return new Result(
                result.get(Rank.FIRST),
                result.get(Rank.SECOND),
                result.get(Rank.THIRD),
                result.get(Rank.FORTH),
                result.get(Rank.FIFTY),
                revenueRate
        );
    }

    private long getTotalPrize(Map<Rank, Integer> result) {
        return result.keySet()
                .stream()
                .mapToLong(rank ->
                        rank.multiplePrize(
                                result.get(rank)
                        )
                )
                .sum();
    }
}
