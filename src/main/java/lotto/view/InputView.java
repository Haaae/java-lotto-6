package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionCode;
import lotto.utils.converter.Converter;

public class InputView {

    public long readPurchasePrice() {
        Notice.NOTICE_PURCHASE_PRICE.print();

        String input = Console.readLine();

        return Converter.toLong(
                input,
                ExceptionCode.INVALID_PURCHASE_PRICE
        );
    }
}
