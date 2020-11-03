public class SimpleRecursion3 {
    public static int sum2(int[] a, int startIndex, int endIndex) {
        if (startIndex == endIndex + 1) {
            return 0;
        }
        return sum2(a, startIndex, endIndex-1) + a[endIndex];
    }

    public static void main(String[] args) {
        int[] a = {9, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum2(a, 0, 0));
    }
}
