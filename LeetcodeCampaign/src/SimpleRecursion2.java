public class SimpleRecursion2 {
    public static int sum1(int[] a, int i)
    {
        if(i<0){
            return 0;
        }
        return sum1(a,i-1)+a[i];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println( sum1(a,a.length-1));
    }
}
