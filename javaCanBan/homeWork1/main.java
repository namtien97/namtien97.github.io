package homeWork1;

import java.util.Scanner;

class NhapDuLieu {
    public static void main(String[] args) {
        final byte thangTrongNam = 12;
        final byte phanTram = 100;

        double tienGoc = readInput("Tiền gốc vay: ", 1000, 1000000, "Xin hay nhap lai lon hon 1k va nho hon 1000k");

        float laiSuatTheoNam = (float) readInput("Lãi suất (theo năm): ", 0, 30,
                "Xin hay nhap lai lon hon 0 va nho hon 30");
        float laiSuatTheoThang = laiSuatTheoNam / thangTrongNam / phanTram;

        int kyHanVayTheoNam = (int) readInput("Kỳ hạn vay theo năm: ", 1, 30,
                "Xin hay nhap lai lon hon 1 va nho hon 30");
        int kyHanVayTheoThang = kyHanVayTheoNam * thangTrongNam;

        double tienPhaiTraHangThang = tienPhaiTraHangThang(tienGoc, laiSuatTheoThang, kyHanVayTheoThang);
        System.out.print("Tiền trả nợ hàng tháng: " + tienPhaiTraHangThang);
    }

    public static double readInput(String message, double min, double max, String erorrMessage) {
        double value;
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        while (true) {
            value = sc.nextInt();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println(erorrMessage);
            }
        }
        return value;
    }

    public static double tienPhaiTraHangThang(double tienGoc, float laiSuatTheoThang, int kyHanVayTheoThang) {
        double tienPhaiTraHangThang = tienGoc * laiSuatTheoThang * Math.pow(1 + laiSuatTheoThang, kyHanVayTheoThang)
                / (Math.pow(1 + laiSuatTheoThang, kyHanVayTheoThang) - 1);
        return tienPhaiTraHangThang;
    }
}
