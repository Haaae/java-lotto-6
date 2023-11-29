package lotto.controller;

import java.util.List;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.service.dto.LottoDto;
import lotto.service.dto.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

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
