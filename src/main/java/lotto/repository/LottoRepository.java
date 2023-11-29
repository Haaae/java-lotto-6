package lotto.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.entity.Lotto;


public class LottoRepository {

    private final List<Lotto> repository = new ArrayList<>();

    public void save(final Lotto lotto) {
        repository.add(lotto);
    }

    public void save(final List<Lotto> entities) {
        entities.forEach(this::save);
    }

    public List<Lotto> finaAll() {
        return Collections.unmodifiableList(repository);
    }
}
