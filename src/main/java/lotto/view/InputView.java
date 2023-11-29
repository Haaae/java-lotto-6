package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.utils.converter.Converter;
import lotto.utils.parser.Parser;
import lotto.view.constant.Notice;
import lotto.view.constant.Regex;

public class InputView {

    public long readPurchasePrice() {
        Notice.NOTICE_PURCHASE_PRICE.print();

        String input = Console.readLine();

        return Converter.toLong(
                input,
                ExceptionCode.INVALID_PURCHASE_PRICE
        );
    }

    public List<Integer> readWinningNumbers() {
        Notice.NOTICE_WINNING_NUMBERS.print();

        String input = Console.readLine();

        return Parser.split(
                        input,
                        Regex.NUMBER_SPLIT.getRegex()
                )
                .stream()
                .map(number ->
                        Converter.toInt(
                                number,
                                ExceptionCode.INVALID_LOTTO_NUMBER
                        )
                )
                .toList();
    }

    public int readBonusNumber() {
        Notice.NOTICE_BONUS_NUMBERS.print();

        String input = Console.readLine();

        return Converter.toInt(input, ExceptionCode.INVALID_LOTTO_NUMBER);
    }
}
