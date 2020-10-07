import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte scoreHuman = 0;
        byte scoreCom = 0;
        for (byte i = 0; i < 3; i++) {
            OanTuTi oanTuTi = new OanTuTi(input("Ban chon \"Keo\", \"Bua\" hay \"La\": ", "Ban phai nhap \"Keo\", \"Bua\" hoac \"La\": "), machineChoose());
            System.out.println("May chon " + machineChoose());
            System.out.println("Ban da " + oanTuTi.logic()+" van nay!");
            if (oanTuTi.logic().equals("thang")) {
                scoreHuman++;
            } else {
                scoreCom++;
            }
            System.out.println("Ban duoc " + scoreHuman + " diem!");
        }
        if (scoreHuman > scoreCom) {
            System.out.println("Ban da thang!");
        } else if (scoreHuman < scoreCom) {
            System.out.println("Ban da thua!");
        } else {
            System.out.println("Hoa!");
        }
    }

    public static String input(String message, String errorMessage) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String userChoose = sc.nextLine();
        while (true) {
            if (userChoose.equals("Keo") || userChoose.equals("Bua") || userChoose.equals("La")) {
                break;
            } else {
                System.out.print(errorMessage);
                userChoose = sc.nextLine();
            }
        }
        return userChoose;
    }

    public static String machineChoose() {
        String[] arrMachineChoose = {"Keo", "La", "Bua"};
        byte indexArrMachineChoose = (byte) (Math.random() * 2);
        return arrMachineChoose[indexArrMachineChoose];
    }
}
