package homeWork2;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap nam vao day de kiem tra: ");
        int year = sc.nextInt();

        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            System.out.println("Day la nam nhuan!");
        } else {
            System.out.println("Day khong phai la nam nhuan!");
        }
    }
}
