package SalesApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaunchedSale extends Sale {
    public List<String> billList = new ArrayList<>();
    MyCompany myCompany = new MyCompany("111", "Nam", "113", "Thu Do", 0, 0);
    Scanner sc = new Scanner(System.in);

    public LaunchedSale() {
        super();
    }

    public void initSale() {
        supplierList.add(new Supplier("123", "Ha Nam", "09123456", "Ha Noi", 0));
        supplierList.add(new Supplier("124", "Ha Nam1", "09123457", "Ha Noi1", 0));
        supplierList.add(new Supplier("125", "Ha Nam2", "09123458", "Ha Noi2", 0));

        customerList.add(new Customer("126", "Ha Nam4", "09123451", "Ha Noi4", 0));
        customerList.add(new Customer("127", "Ha Nam5", "09123452", "Ha Noi5", 0));
        customerList.add(new Customer("128", "Ha Nam6", "09123453", "Ha Noi6", 0));
    }

    public void optionOther() {
        char option;
        do {
            System.out.println("A. Kiem tra luong hang ton kho");
            System.out.println("B. Kiem tra luong tien mat");
            System.out.println("C. Kiem tra nha cung cap");
            System.out.println("D. Kiem tra khach hang");
            System.out.println("E. Thoat");
            System.out.println("Nhap lua chon cua ban");
            System.out.println("------------------------------");
            option = sc.next().charAt(0);
            System.out.println("------------------------------");
            switch (option) {
                case 'A':
                    System.out.println("Hang ton kho: " + myCompany.getGoods());
                    break;
                case 'B':
                    System.out.println("Luong tien mat hien co: " + myCompany.getCash());
                    break;
                case 'C':
                    System.out.println("Nhap id nha cung cap: ");
                    System.out.println("ID:0 - Ha Nam - tax id:123.");
                    System.out.println("ID:1 - Ha Nam1 - tax id:124.");
                    System.out.println("ID:2 - Ha Nam2 - tax id:125.");
                    System.out.println("------------------------------");
                    int idSup = sc.nextInt();
                    System.out.println("------------------------------");
                    System.out.println("Tong giao dich voi nha cung cap: " + supplierList.get(idSup));
                    System.out.println("------------------------------");
                    break;
                case 'D':
                    System.out.println("Nhap id khach hang: ");
                    System.out.println("ID:0 - Ha Nam4 - tax id:126.");
                    System.out.println("ID:1 - Ha Nam5 - tax id:127.");
                    System.out.println("ID:2 - Ha Nam6 - tax id:128.");
                    System.out.println("------------------------------");
                    int idCus = sc.nextInt();
                    System.out.println("------------------------------");
                    System.out.println("Tong giao dich voi khach hang: " + customerList.get(idCus));
                    System.out.println("------------------------------");
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Chon lai lua chon cua ban!");
            }
        } while (option != 'E');
    }

    @Override
    public void increaseMoney() {
        int idCus;
        while (true) {
            System.out.println("Chon id khach hang:");
            System.out.println("ID:0 - Ha Nam4 - tax id:126.");
            System.out.println("ID:1 - Ha Nam5 - tax id:127.");
            System.out.println("ID:2 - Ha Nam6 - tax id:128.");
            System.out.println("------------------------------");
            idCus = sc.nextInt();
            System.out.println("------------------------------");
            if (idCus == 0 || idCus == 1 || idCus == 2) {
                break;
            } else {
                System.out.println("Chon dung id khach hang");
            }
        }
        System.out.println("Nhap so luong hang khach hang lay:");
        System.out.println("------------------------------");
        int goodsCus = sc.nextInt();
        System.out.println("------------------------------");
        System.out.println("Nhap so tien cua khach hang:");
        System.out.println("------------------------------");
        double moneyCus = sc.nextDouble();
        customerList.get(idCus).increaseTrans(moneyCus);
        System.out.println("------------------------------");
        myCompany.saleGoods(goodsCus, moneyCus);
        System.out.println("Nhap ghi chu:");
        System.out.println("------------------------------");
        String str = sc.next();
        billList.add(str);
        System.out.println("------------------------------");
    }

    @Override
    public void decreaseMoney() {
        int idSup;
        while (true) {
            System.out.println("Chon id nha cung cap:");
            System.out.println("ID:0 - Ha Nam - tax id:123.");
            System.out.println("ID:1 - Ha Nam1 - tax id:124.");
            System.out.println("ID:2 - Ha Nam2 - tax id:125.");
            System.out.println("------------------------------");
            idSup = sc.nextInt();
            System.out.println("------------------------------");
            if (idSup == 0 || idSup == 1 || idSup == 2) {
                break;
            } else {
                System.out.println("Chon dung id nha cung cap");
            }
        }
        System.out.println("Nhap so luong hang nhap kho:");
        System.out.println("------------------------------");
        int goodsSup = sc.nextInt();
        System.out.println("------------------------------");
        System.out.println("Nhap so tien cua nha cung cap:");
        System.out.println("------------------------------");
        double moneySup = sc.nextDouble();
        supplierList.get(idSup).increaseTrans(moneySup);
        System.out.println("------------------------------");
        myCompany.importGoods(goodsSup, moneySup);
        System.out.println("Nhap ghi chu:");
        System.out.println("------------------------------");
        String str = sc.next();
        billList.add(str);
        System.out.println("------------------------------");
    }

}
