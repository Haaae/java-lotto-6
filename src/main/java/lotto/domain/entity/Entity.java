package lotto.domain.entity;

public abstract class Entity {

    private static Long countOfId = 0L;

    public abstract Long getId();

    /**
     * 현재 countOfId를 반환 후 1 증가
     */
    protected Long getNextId() {
        return countOfId++;
    }
}
