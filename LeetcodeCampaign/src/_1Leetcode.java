import java.util.HashMap;
import java.util.Map;

public class _1Leetcode {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k)) {
                int kIndex = map.get(k);
                if(kIndex != i){
                    results[0] = i;
                    results[1] = map.get(k);
                    break;
                }
            }
        }
        return results;
    }
}
