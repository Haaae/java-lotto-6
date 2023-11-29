package lotto.view;

import java.util.List;
import lotto.service.dto.LottoDto;
import lotto.view.constant.Format;

public class OutputView {
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
}
