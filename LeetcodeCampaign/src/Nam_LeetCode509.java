public class Nam_LeetCode509 {
    static int[] F = new int[1000];
    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 2 || N == 1) {
            return 1;
        }
        return F[N]=fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(11));
    }
}
