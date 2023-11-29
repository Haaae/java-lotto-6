package lotto.view;

public enum Format {

    COUNT_OF_LOTTO("%d개를 구매했습니다."),
    ;

    private final String format;

    Format(final String format) {
        this.format = format;
    }

    public void print(Object... args) {
        System.out.printf(format, args);
    }
}

