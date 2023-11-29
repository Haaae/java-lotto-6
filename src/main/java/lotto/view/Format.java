package lotto.view;

public enum Format {

    PRICE("%s원\n"),
    ;

    private final String format;

    Format(final String format) {
        this.format = format;
    }

    public void print(Object... args) {
        System.out.printf(format, args);
    }
}

