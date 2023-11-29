package lotto.view.constant;

public enum Notice {

    NOTICE_PURCHASE_PRICE("구입금액을 입력해 주세요.\n로또 한장은 1,000원이며, 구입금액은 1,000원 단위로 입력할 수 있습니다."),
    NOTICE_WINNING_NUMBERS("당첨 번호를 입력해 주세요. 당첨 번호는 ','로 구분된 1 ~ 45 범위의 숫자 6개입니다."),
    NOTICE_BONUS_NUMBERS("보너스 번호를 입력해 주세요. 보너스 번호는 당첨 번호와 겹치지 않는 1 ~ 45 범위의 숫자 1개입니다."),

    ;

    private final String notice;

    Notice(final String notice) {
        this.notice = notice;
    }

    public void print() {
        System.out.println(notice);
    }
}

