package lotto.controller;

import java.util.List;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.service.dto.LottoDto;
import lotto.service.dto.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final LottoController instance = new LottoController();

    private LottoController() {
    }

    public static LottoController getInstance() {
        return instance;
    }

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final LottoService lottoService = LottoService.getInstance();

    public void run() {
        ExceptionHandler.handle(this::generateLottosFromUserInput);
        printPurchaseLottos();

        ExceptionHandler.handle(this::createWinningNumbersFromUserInput);

        Long bonusNumberId = ExceptionHandler.handle(this::createBonusNumberFromUserInput);

        Result result = lottoService.getResult(bonusNumberId);
        outputView.printResult(result);
    }

    private long createBonusNumberFromUserInput() {
        int bonusNumber = inputView.readBonusNumber();
        return lottoService.createBonusNumber(bonusNumber);
    }

    private void createWinningNumbersFromUserInput() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        lottoService.createWinningNumbers(winningNumbers);
    }

    private void printPurchaseLottos() {
        List<LottoDto> lottoDtos = lottoService.getLottos();
        outputView.printLottos(lottoDtos);
    }

    private void generateLottosFromUserInput() {
        long purchasePrice = inputView.readPurchasePrice();
        lottoService.generateLottos(purchasePrice);
    }
}
