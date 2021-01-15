package thiGiuaKi;

public class _724Leetcode {
    static public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sumRight(i, nums) == sumLeft(i, nums)) {
                return i;
            }
        }
        return -1;
    }

    static public int sumRight(int index, int[] nums) {
        int result = 0;
        for (int i = index + 1; i <= nums.length - 1; i++) {
            result += nums[i];
        }
        return result;
    }

    static public int sumLeft(int index, int[] nums) {
        int result = 0;
        for (int i = index - 1; i >= 0; i--) {
            result += nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        System.out.println(pivotIndex(nums1));
    }

}
