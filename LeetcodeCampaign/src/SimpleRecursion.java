public class SimpleRecursion {
    public static int find(int x, int[] a, int i) {
        if (x == a[i]) {
            return i;
        }
        if (i > 0) {
            return -1;
        }
        return find(x, a, i-1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println( find(11,a,a.length-1));
    }
}
