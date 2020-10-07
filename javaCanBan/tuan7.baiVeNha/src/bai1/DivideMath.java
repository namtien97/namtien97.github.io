package bai1;

public class DivideMath {
    private double a;
    private double b;


    public DivideMath(double a, double b) throws MathException {
        if (b == 0) {
            throw new MathException("B must different 0");
        } else {
            this.a = a;
            this.b = b;
        }
    }

    public double div(){
        return a/b;
    }
}
