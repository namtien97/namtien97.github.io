import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]) == false) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}
