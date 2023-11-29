package lotto.view;

import java.util.List;
import lotto.domain.Rank;
import lotto.service.dto.LottoDto;
import lotto.service.dto.Result;
import lotto.view.constant.Format;
import lotto.view.constant.Notice;
import lotto.view.constant.Regex;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printLottos(final List<LottoDto> lottoDtos) {
        System.out.println();

        int countOfLotto = lottoDtos.size();
        Format.COUNT_OF_LOTTO.print(countOfLotto);

        lottoDtos.forEach(lottoDto ->
                System.out.println(
                        lottoDto.numbers()
                )
        );
    }

    public void printResult(final Result result) {
        printResultHead();
        printCountPerRank(result);
        printRevenueRate(result.revenueRate());
    }

    private void printRevenueRate(final float revenueRate) {
        Format.REVENUE_RATE.print(
                Regex.formatRounds(revenueRate)
        );
    }

    private void printCountPerRank(final Result result) {
        printCountOfRank(Rank.FIFTY, result.countOfFifty());
        printCountOfRank(Rank.FORTH, result.countOfForth());
        printCountOfRank(Rank.THIRD, result.countOfThird());
        printCountOfSecondRank(result.countOfSecond());
        printCountOfRank(Rank.FIRST, result.countOfFirst());
    }

    private void printCountOfRank(final Rank rank, final int count) {
        Format.COUNT_OF_RANK.print(
                rank.getCount(),
                Regex.formatCashPrize(
                        rank.getPrize()
                ),
                count
        );
    }

    private void printCountOfSecondRank(final int count) {
        Format.COUNT_OF_SECOND.print(
                Rank.SECOND.getCount(),
                Regex.formatCashPrize(
                        Rank.SECOND.getPrize()
                ),
                count
        );
    }

    private void printResultHead() {
        System.out.println();
        Notice.NOTICE_RESULT.print();
        System.out.println(
                Regex.BAR.getRegex()
        );
    }
}
