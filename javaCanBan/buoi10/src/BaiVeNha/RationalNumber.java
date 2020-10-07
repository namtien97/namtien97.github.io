package BaiVeNha;

public class RationalNumber extends ComparableNumber<RationalNumber> {

    private int tuSo;
    private int mauSo;

    public RationalNumber(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new ArithmeticException("Mau so khong hop le!");
        }
        int USCLN = greatestCommonDivisor(tuSo, mauSo);

        tuSo /= USCLN;
        mauSo /= USCLN;

        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }

        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    private int greatestCommonDivisor(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    ;

    @Override
    public double doubleValue() {
        return  ((double)tuSo / mauSo);
    }

    @Override
    public RationalNumber add(RationalNumber other) {
        return new RationalNumber(
                this.tuSo * other.mauSo + other.tuSo * this.mauSo,
                this.mauSo * other.mauSo
        );
    }

    @Override
    public RationalNumber sub(RationalNumber other) {
        return new RationalNumber(
                this.tuSo * (-1),
                other.mauSo
        );
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}
