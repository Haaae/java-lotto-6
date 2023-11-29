package lotto.service;

import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.entity.Lotto;
import lotto.repository.LottoRepository;
import lotto.service.dto.LottoDto;

public class LottoService {

    private final LottoGenerator lottoGenerator;
    private final LottoRepository lottoRepository;

    public LottoService(LottoGenerator lottoGenerator, LottoRepository lottoRepository) {
        this.lottoGenerator = lottoGenerator;
        this.lottoRepository = lottoRepository;
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
}
