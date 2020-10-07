package BaiVeNha;

public class DoubleNumber extends ComparableNumber<DoubleNumber> {
    private final double value;

    public DoubleNumber(double value) {
        this.value = value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public DoubleNumber add(DoubleNumber other) {
        return new DoubleNumber(this.doubleValue() + other.doubleValue());
    }

    @Override
    public DoubleNumber sub(DoubleNumber other) {
        return new DoubleNumber(this.doubleValue() - other.doubleValue());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
