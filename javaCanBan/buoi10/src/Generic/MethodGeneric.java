package Generic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MethodGeneric {
    public static <T> void showArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static <T extends Comparable> void sort(T[] arr) {
        Arrays.sort(arr);
    }
}
