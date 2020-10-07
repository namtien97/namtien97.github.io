package homeWork2;

import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap toa do x,y (x truoc, y sau va cach nhau boi dau cach): ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        if (x >= -5 && x <= 5 && y >= -2.5 && y <= 2.5) {
            System.out.println("Toa do ben trong HCN");
        } else {
            System.out.println("Toa do ben ngoai HCN");
        }
    }
}
