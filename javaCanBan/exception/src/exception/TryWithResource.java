package exception;

//try with resource

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        try (Scanner readFile = new Scanner(
                new File("E:\\Techmaster\\namtien97.github.io\\javaCanBan\\exception\\src\\exception\\ThrowVSThrows.java"),
                "UTF8");
             PrintWriter printWriter =
                     new PrintWriter(("E:\\Techmaster\\namtien97.github.io\\javaCanBan\\exception\\src\\exception\\ThrowVSThrows.DAT"),
                             "UTF-8")) {
            while (readFile.hasNextLine()){
                var input = readFile.nextLine();
                printWriter.println(input);
            }
        }
    }
}