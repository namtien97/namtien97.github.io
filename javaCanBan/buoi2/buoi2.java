package buoi2;

import java.util.Scanner;

public class buoi2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        if (a % 5 == 0 && a % 3 != 0) {
            System.out.println("Fizz");
        } else if (a % 3 == 0 && a % 5 != 0) {
            System.out.println("Buzz");
        } else if (a % 3 == 0 && a % 5 == 0) {
            System.out.println("FizzBuzz");
        } else {
            System.out.println(a);
        }
    }
}
