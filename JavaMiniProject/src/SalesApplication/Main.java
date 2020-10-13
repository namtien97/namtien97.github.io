package SalesApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var launchedSale = new LaunchedSale();
        launchedSale.initSale();
        char option;

        Scanner scanner = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("\t\tWelcome to sale system");
        System.out.println("***************************************");
        do {
            System.out.println("A. Nhap hang tu nha cung cap");
            System.out.println("B. Ban hang cho khach hang");
            System.out.println("C. Kiem tra thong tin");
            System.out.println("D. Thoat");
            System.out.println("------------------------------");
            System.out.println("Nhap lua chon cua ban:");
            System.out.println("------------------------------");
            option = scanner.next().charAt(0);
            System.out.println("------------------------------");
            switch (option) {
                case 'A':
                    launchedSale.decreaseMoney();
                    break;
                case 'B':
                    launchedSale.increaseMoney();
                    break;
                case 'C':
                    launchedSale.optionOther();
                    break;
                case 'D':
                    System.out.println("***************************************");
                    break;
                default:
                    System.out.println("Nhap \"A\",\"B\" hoac \"C\"");
                    System.out.println("------------------------------");
                    break;
            }
        } while (option != 'D');
        System.out.println("\tThank you for using our services");
    }
}
