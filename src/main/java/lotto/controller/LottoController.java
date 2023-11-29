package lotto.controller;

import java.util.List;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.service.dto.LottoDto;
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
