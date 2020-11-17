import java.util.HashMap;
import java.util.Map;

public class _349IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                int newValue = map.get(nums2[i]) + 1;
                map.put(nums2[i], newValue);
            }
        }
        for (Map.Entry e : map.entrySet()) {
            if (!e.getValue().equals(1)) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (Map.Entry e : map.entrySet()) {
            if (!e.getValue().equals(1)) {
                result[index] = (int) e.getKey();
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        intersection(nums1, nums2);
    }
}
