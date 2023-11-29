package lotto.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lotto.domain.entity.Lotto;


public class LottoRepository {
    
    private static final LottoRepository instance = new LottoRepository();

        private LottoRepository() {
        }

        public static LottoRepository getInstance() {
            return instance;
        }

    private final List<Lotto> repository = new ArrayList<>();
    private Lotto winningNumbers;

    public void save(final Lotto lotto) {
        repository.add(lotto);
    }

    public void save(final List<Lotto> entities) {
        entities.forEach(this::save);
    }

    public void saveWinningNumbers(final Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Optional<Lotto> findWinningNumbers() {
        return Optional.ofNullable(winningNumbers);
    }

    public List<Lotto> finaAll() {
        return Collections.unmodifiableList(repository);
    }
}
