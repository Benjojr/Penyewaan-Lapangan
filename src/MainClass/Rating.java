package MainClass;
public enum Rating {
    ONE("⭐"),
    TWO("⭐⭐"),
    THREE("⭐⭐⭐"),
    FOUR("⭐⭐⭐⭐"),
    FIVE("⭐⭐⭐⭐⭐");

    private final String symbol;
    Rating(String symbol) {
        this.symbol = symbol;
    }

    public static Rating fromInt(int value) {
        return switch (value) {
            case 1 -> ONE;
            case 2 -> TWO;
            case 3 -> THREE;
            case 4 -> FOUR;
            case 5 -> FIVE;
            default -> throw new IllegalArgumentException("Invalid rating value: " + value);
        };
    }

    public int toInt() {
        return ordinal() + 1;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
