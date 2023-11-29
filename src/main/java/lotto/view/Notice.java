package lotto.view;

public enum Notice {

    NOTICE_WELCOME("안녕하세요!"),

    ;

    private final String notice;

    Notice(final String notice) {
        this.notice = notice;
    }

    public void print() {
        System.out.println(notice);
    }
}

