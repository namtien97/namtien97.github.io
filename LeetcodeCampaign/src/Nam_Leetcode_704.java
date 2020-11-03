public class Nam_Leetcode_704 {
    public static int bSearch(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int k = (l + r) / 2;
        if (nums[k] == target) {
            return k;
        }
        if (nums[k] < target) {
            return bSearch(nums, target, k + 1, r);
        }
        return bSearch(nums, target, l, k - 1);
    }

    public static int search(int[] nums, int target) {
        return bSearch(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }
}
