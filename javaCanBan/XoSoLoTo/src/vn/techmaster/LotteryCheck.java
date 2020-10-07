package vn.techmaster;

public class LotteryCheck {

    private char lotteryDigit1;
    private char lotteryDigit2;
    private char numberDigit1;
    private char numberDigit2;

    public String getAward(Input numbers){
        var lotteryNumber = numbers.getLotteryNumber();
        var number = numbers.getNumber();

        lotteryDigit1 = lotteryNumber.charAt(0);
        lotteryDigit2 = lotteryNumber.charAt(1);
        numberDigit1 = number.charAt(0);
        numberDigit2 = number.charAt(1);

        if (lotteryNumber.equals(number))
            return "Giai dac biet";
        else if (lotteryDigit1 == numberDigit2
                && lotteryDigit2 == numberDigit1)
            return "Giai nhat";
        else if (lotteryDigit1 == numberDigit1
                || lotteryDigit1 == numberDigit2
                || lotteryDigit2 == numberDigit1
                || lotteryDigit2 == numberDigit2
        )
            return "Giai khuyen khich";
        else
            return "Khong co giai";
    }
}
