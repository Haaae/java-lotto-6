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
        printCountOfRank(Rank.FIRST, result.countOfFirst());
        printCountOfRank(Rank.SECOND, result.countOfSecond());
        printCountOfRank(Rank.THIRD, result.countOfThird());
        printCountOfRank(Rank.FORTH, result.countOfForth());
        printCountOfRank(Rank.FIFTY, result.countOfFifty());
    }

    private static void printCountOfRank(final Rank first, final int result) {
        Format.COUNT_OF_RANK.print(
                first.getCount(),
                Regex.formatCashPrize(
                        first.getPrize()
                ),
                result
        );
    }

    private static void printResultHead() {
        System.out.println();
        Notice.NOTICE_RESULT.print();
        System.out.println(
                Regex.BAR.getRegex()
        );
    }
}
