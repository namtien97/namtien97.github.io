package homeWork2;

import java.util.Scanner;

public class bai8 {
    public static void main(String[] args) {

        byte yourBirthday = 0;

        byte[][] set1 = { { 1, 3, 5, 7 }, { 9, 11, 13, 15 }, { 17, 19, 21, 23 }, { 25, 27, 29, 31 } };
        byte[][] set2 = { { 2, 3, 6, 7 }, { 10, 11, 14, 15 }, { 18, 19, 22, 23 }, { 26, 27, 30, 31 } };
        byte[][] set3 = { { 4, 5, 6, 7 }, { 12, 13, 14, 15 }, { 20, 21, 22, 23 }, { 28, 29, 30, 31 } };
        byte[][] set4 = { { 8, 9, 10, 11 }, { 12, 13, 14, 15 }, { 24, 25, 26, 27 }, { 28, 29, 30, 31 } };
        byte[][] set5 = { { 16, 17, 18, 19 }, { 20, 21, 22, 23 }, { 24, 25, 26, 27 }, { 28, 29, 30, 31 } };

        String answerForSet1 = readInput("Ngày sinh của bạn có trong các số này không? Trả lời \"yes\" hoặc \"no\":",
                "Bạn phải nhập \"yes\" hoặc \"no\", xin hãy nhập lại:", set1);
        byte processAnserForSet1 = processAnswer(set1, yourBirthday, answerForSet1);
        String answerForSet2 = readInput("Ngày sinh của bạn có trong các số này không? Trả lời \"yes\" hoặc \"no\":",
                "Bạn phải nhập \"yes\" hoặc \"no\", xin hãy nhập lại:", set2);
        byte processAnserForSet2 = processAnswer(set2, yourBirthday, answerForSet2);
        String answerForSet3 = readInput("Ngày sinh của bạn có trong các số này không? Trả lời \"yes\" hoặc \"no\":",
                "Bạn phải nhập \"yes\" hoặc \"no\", xin hãy nhập lại:", set3);
        byte processAnserForSet3 = processAnswer(set3, yourBirthday, answerForSet3);
        String answerForSet4 = readInput("Ngày sinh của bạn có trong các số này không? Trả lời \"yes\" hoặc \"no\":",
                "Bạn phải nhập \"yes\" hoặc \"no\", xin hãy nhập lại:", set4);
        byte processAnserForSet4 = processAnswer(set4, yourBirthday, answerForSet4);
        String answerForSet5 = readInput("Ngày sinh của bạn có trong các số này không? Trả lời \"yes\" hoặc \"no\":",
                "Bạn phải nhập \"yes\" hoặc \"no\", xin hãy nhập lại:", set5);
        byte processAnserForSet5 = processAnswer(set5, yourBirthday, answerForSet5);
        yourBirthday = (byte) (processAnserForSet1 + processAnserForSet2 + processAnserForSet3 + processAnserForSet4
                + processAnserForSet5);
        System.out.print("Vậy ngày sinh của bạn là ngày: " + yourBirthday);
    }

    public static String readInput(String message, String errorMessage, byte[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (byte i = 0; i < 4; i++) {
            for (byte j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println(message);
        String answer = sc.nextLine();
        while (true) {
            if (answer.equals("yes") | answer.equals("no")) {
                break;
            } else {
                System.out.println(errorMessage);
                answer = sc.nextLine();
            }
        }
        return answer;
    }

    public static byte processAnswer(byte[][] arr, byte number, String answer) {
        if (answer.equals("yes")) {
            number += arr[0][0];
        }
        return number;
    }
}
