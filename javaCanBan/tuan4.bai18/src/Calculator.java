public class Calculator {
    private double a;
    private double b;
    private double c;

public Calculator(double a, double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;
}

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getAnswer3(double alpha) {
        double answer3 = (-getB()-Math.sqrt(alpha))/(2*getA());
        return answer3;
    }

    public double getAnswer2(double alpha) {
        double answer2 = (-getB()+Math.sqrt(alpha))/(2*getA());
        return answer2;
    }

    public double getAnswer1() {
        double answer1 = -(getB()/(2*getA()));
        return answer1;
    }

    public double getAlpha() {
        double alpha = Math.pow(getB(),2) - 4*getA()*getC();
        return alpha;
    }
}
