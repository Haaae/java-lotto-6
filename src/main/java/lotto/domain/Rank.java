package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(1, 6, 2_000_000_000, BonusMatch.NO_MATTER),
    SECOND(2, 5, 30_000_000, BonusMatch.NEED),
    THIRD(3, 5, 1_500_000, BonusMatch.NOT_NEED),
    FORTH(4, 4, 50_000, BonusMatch.NO_MATTER),
    FIFTY(5, 3, 5_000, BonusMatch.NO_MATTER),
    NOTING(-1, -1, 0, BonusMatch.NO_MATTER),
    ;

    private final int rank;
    private final int count;
    private final int prize;
    private final BonusMatch bonusMatch;

    Rank(int rank, int count, int prize, BonusMatch bonusMatch) {
        this.rank = rank;
        this.count = count;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public static Rank from(final int count, final boolean isBonusMatched) {
        return Arrays.stream(values())
                .filter(r -> r.count == count)
                .filter(r -> r.bonusMatch.satisfiedBy(isBonusMatched))
                .findFirst()
                .orElse(NOTING);
    }

    public static Map<Rank, Integer> createCountBoard() {
        return  Arrays.stream(Rank.values())
                .collect(Collectors.toMap(
                                rank -> rank,
                                rank -> 0
                        )
                );
    }

    public long multiplePrize(final int multiple) {
        return (long) prize * multiple;
    }
}
