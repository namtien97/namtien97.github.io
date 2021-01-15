package thiCuoiKi;

import java.util.HashSet;
import java.util.Set;

public class _1672Leetcode {
    static public int maximumWealth(int[][] accounts) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum+=accounts[i][j];
            }
            if(result<sum){
                result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.println(maximumWealth(accounts));
    }
}
