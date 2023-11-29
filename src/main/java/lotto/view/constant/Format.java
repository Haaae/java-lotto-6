package lotto.view.constant;

public enum Format {

    COUNT_OF_LOTTO("%d개를 구매했습니다.\n"),
    COUNT_OF_RANK("%d개 일치 (%s원) - %d개\n"),
    COUNT_OF_SECOND("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    REVENUE_RATE("총 수익률은 %s%%입니다.\n"),
    ;

    private final String format;

    Format(final String format) {
        this.format = format;
    }

    public void print(Object... args) {
        System.out.printf(format, args);
    }
}

