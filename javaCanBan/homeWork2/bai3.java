package homeWork2;

public class bai3 {
    public static void main(String[] args) {
        String[] listMonth = { "tháng một", "tháng hai", "tháng ba", "tháng bốn", "tháng năm", "tháng sáu", "tháng 7",
                "tháng 8", "tháng 9", "tháng 10", "tháng 11", "tháng 12" };
        byte randomNumber = (byte) (Math.random() * 17);
        System.out.println(listMonth[randomNumber]);
    }
}
