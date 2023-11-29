package lotto.repository;

import lotto.domain.entity.BonusNumber;

public class BonusRepository extends Repository<BonusNumber>{

    private static final BonusRepository instance = new BonusRepository();

    private BonusRepository() {
    }

    public static BonusRepository getInstance() {
        return instance;
    }
}
