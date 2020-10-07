package vn.techmaster;

import java.util.Random;
import java.util.Scanner;

public class Input {
    private String lotteryNumber;
    private String number;

    public String getLotteryNumber(){
        lotteryNumber =
                "" + (int)(Math.random()*10) + (int)(Math.random()*10);
        return lotteryNumber;
    }

    public String getNumber(){
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        return number;
    }

    public void printLotteryNumber(){
        System.out.println("Giai dac biet la"+ lotteryNumber);
    }
}
