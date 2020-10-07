package homeWork2;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài 3 cạnh tam giác(mỗi cạnh cách nhau 1 dấu cách): ");
        double canh1 = sc.nextDouble();
        double canh2 = sc.nextDouble();
        double canh3 = sc.nextDouble();
        if (canh1 + canh2 > canh3 || canh2 + canh3 > canh1 || canh3 + canh1 > canh2) {
            double chuVi = canh1 + canh2 + canh3;
            System.out.print("Chu vi hinh tam giac là: " + chuVi);
        } else {
            System.out.println("Đây không phải là hình tam giác!");
        }
    }
}
