package vn.techmaster;

public class Main {
    public static void main(String[] args) {
        var input = new Input();
        var lotteryNumber = input.getLotteryNumber();
        input.printLotteryNumber();
        var number = input.getNumber();

        var lotteryCheck = new LotteryCheck();
        var award = lotteryCheck.getAward(lotteryNumber number);
        var display = new DisplayAward();
        display.printAward(award);
    }
}
