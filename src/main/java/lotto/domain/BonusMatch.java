package lotto.domain;

public enum BonusMatch {
    NEED {
        @Override
        public boolean satisfiedBy(final boolean isBonusMatched) {
            return isBonusMatched;
        }
    },
    NOT_NEED {
        @Override
        public boolean satisfiedBy(final boolean isBonusMatched) {
            return !isBonusMatched;
        }
    },
    NO_MATTER {
        @Override
        public boolean satisfiedBy(final boolean isBonusMatched) {
            return true;
        }
    },
    ;

    public abstract boolean satisfiedBy(final boolean isBonusMatched);
}
