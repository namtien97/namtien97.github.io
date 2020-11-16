public class NamLeetCode70 {
    static int [] steps = new int[46];
    public static int climbStairs(int n) {
        if(steps[n]!=0){
            return steps[n];
        }
        if(n<=1){
            return 1;
        }
        steps[n]= climbStairs(n-2)+climbStairs(n-1);
        return steps[n];
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs(n));
    }
}
