package lotto.service.dto;

public record Result(
        int countOfFirst,
        int countOfSecond,
        int countOfThird,
        int countOfForth,
        int countOfFifty,
        long purchasePrice,
        long totalPrize
) {
    public float getRevenueRate() {
        if (purchasePrice == 0) {
            return 0;
        }

        return (float) totalPrize / purchasePrice * 100;
    }
}
