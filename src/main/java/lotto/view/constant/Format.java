package lotto.view.constant;

public enum Format {

    COUNT_OF_LOTTO("%d개를 구매했습니다."),
    COUNT_OF_RANK("%d개 일치 (%s원) - %d개"),
    REVENUE_RATE("총 수익률은 %f입니다."),
    ;

    private final String format;

    Format(final String format) {
        this.format = format;
    }

    public void print(Object... args) {
        System.out.printf(format, args);
    }
}

