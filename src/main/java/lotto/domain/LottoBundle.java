package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.Lotto;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> calculateRank(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        Map<Rank, Integer> countBoard = Rank.createCountBoard();

        lottos.forEach(lotto -> {
                    increaseMatchRankCount(winningNumbers, bonusNumber, lotto, countBoard);
                }
        );

        return countBoard;
    }

    private static void increaseMatchRankCount(
            Lotto winningNumbers,
            BonusNumber bonusNumber,
            Lotto lotto,
            Map<Rank, Integer> countBoard
    ) {
        Rank rank = Rank.from(lotto.calculateMatchCount(winningNumbers), lotto.contains(bonusNumber.getNumber()));
        countBoard.put(
                rank,
                countBoard.get(rank) + 1
        );
    }

    public float calculateRevenueRate(final long totalPrize) {
        return (float) totalPrize / (lottos.size() * 1_000) * 100;
    }
}
