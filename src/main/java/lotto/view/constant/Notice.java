package lotto.view.constant;

public enum Notice {

    NOTICE_PURCHASE_PRICE("구입금액을 입력해 주세요.\n로또 한장은 1,000원이며, 구매금액은 1,000원 단위로 입력할 수 있습니다."),

    ;

    private final String notice;

    Notice(final String notice) {
        this.notice = notice;
    }

    public void print() {
        System.out.println(notice);
    }
}

