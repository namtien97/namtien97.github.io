package exception;

/*
throw vs throws:
    -Phân biệt?
    - Cách sử dụng?
    - Khi nào sử dụng?
 */

public class ThrowVSThrows {
    public static double div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("divide by zero");
        }
        return 1.0 * a / b;
    }

    public static void countTime(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try{
            var res = div(10,0);
        }catch (ArithmeticException e){
            System.out.println("Nhap mau khac 0");
        }
    }
}
