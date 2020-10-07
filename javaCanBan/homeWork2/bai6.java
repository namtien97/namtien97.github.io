package homeWork2;

public class bai6 {
    public static void main(String[] args) {
        String[] boBai = { "át cơ", "át bích", "át tép", "át rô", "2 cơ", "2 bích", "2 tép", "2 rô", "3 cơ", "3 bích",
                "4 tép", "4 rô", "5 bích", "5 cơ", "5 tép", "5 rô", "6 bích", "6 cơ", "6 tép", "6 rô", "7 bích", "7 cơ",
                "7 tép", "7 rô", "8 bích", "8 tép", "8 cơ", "8 rô", "9 bích", "9 tép", "9 rô", "9 cơ", "10 bích",
                "10 tép", "10 rô", "10 cơ", "J bích", "J tép", "J cơ", "J rô", "Q bích", "Q tép", "Q cơ", "Q rô",
                "K cơ", "K bích", "K tép", "K rô" };
        byte randomNumber = (byte) (Math.random() * 51);
        System.out.print("Lá bài bạn vừa rút ra là " + boBai[randomNumber]);
    }
}
