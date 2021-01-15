package thiGiuaKi;


import java.util.HashSet;
import java.util.Set;

public class _202Leetcode {
    static public boolean isHappy(int n) {
        Set set = new HashSet();
        while (!(set.contains(n))) {
            set.add(n);
            n = sum(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }

    static public int sum(int n) {
        int total = 0;
        int temp = n;
        while (!((temp) < 1)) {
            total += (temp % 10) * (temp % 10);
            temp = temp / 10;
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }
}
