package lotto.service;

import java.util.List;
import lotto.domain.LottoBundle;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoManager;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.Lotto;
import lotto.exception.ExceptionCode;
import lotto.repository.BonusRepository;
import lotto.repository.LottoRepository;
import lotto.repository.Repository;
import lotto.service.dto.LottoDto;
import lotto.service.dto.Result;

public class LottoService {

    private final LottoGenerator lottoGenerator;
    private final LottoManager lottoManager;
    private final LottoRepository lottoRepository;
    private final BonusRepository bonusRepository;

    public LottoService(LottoGenerator lottoGenerator, LottoManager lottoManager, LottoRepository lottoRepository, BonusRepository bonusRepository) {
        this.lottoGenerator = lottoGenerator;
        this.lottoManager = lottoManager;
        this.lottoRepository = lottoRepository;
        this.bonusRepository = bonusRepository;
    }

    public void generateLottos(final long purchasePrice) {
        List<Lotto> lottos = lottoGenerator.generate(purchasePrice);
        lottoRepository.save(lottos);
    }

    public List<LottoDto> getLottos() {
        return lottoRepository.finaAll()
                .stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    public void createWinningNumbers(final List<Integer> winningNumbers) {
        lottoRepository.saveWinningNumbers(new Lotto(winningNumbers));
    }

    public Long createBonusNumber(final int bonusNumber) {
        Lotto winningNumbers = getWinningNumbers();

        BonusNumber savedBonusNumber = bonusRepository.save(new BonusNumber(bonusNumber, winningNumbers));
        return savedBonusNumber.getId();
    }

    public Result getResult(final Long bonusNumberId) {
        BonusNumber bonusNumber = Repository.findEntity(bonusRepository, bonusNumberId, ExceptionCode.NO_EXIST_ENTITY);
        LottoBundle lottoBundle = new LottoBundle(lottoRepository.finaAll());
        Lotto winningNumbers = getWinningNumbers();

        return lottoManager.createResult(lottoBundle, winningNumbers, bonusNumber);
    }

    private Lotto getWinningNumbers() {
        return lottoRepository.findWinningNumbers()
                .orElseThrow(IllegalArgumentException::new);
    }
}
