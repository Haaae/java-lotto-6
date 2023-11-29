package lotto.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

/**
 entity의 상태를 update하는 메서드는 별도로 존재하지 않는다.
 entity를 update할 때는 entity를 find하여 엔티티 내부의 메서드를 사용해 상태를 변경한다.
 또한 되도록 entity의 값은 불변 값으로 하여 값을 변경하는 일 자체를 없도록 한다.
 */
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

