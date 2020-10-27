public class ThirdMaxiumNumber_414 {
    public static int thirdMax(int[] nums) {
        int result = 0;
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[0];
            } else {
                return nums[1];
            }
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            //ap dung thuat toan sap xep chon
            for (int i = 0; i < nums.length; i++) {
                int indexMin = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[indexMin]) {
                        indexMin = j;
                    }
                }
                if (indexMin != i) {
                    int t = nums[i];
                    nums[i] = nums[indexMin];
                    nums[indexMin] = t;
                }
            }

            for (int k = nums.length - 2; k >= 0; k--) {
                if(nums.length==3&&(nums[0]==nums[1]||nums[1]==nums[2])){
                    return nums[nums.length-1];
                }
                if (k == 0) {
                    return nums[k];
                }
                if (nums[k] > nums[k - 1] && nums[k] != nums[nums.length - 2]) {
                    return nums[k];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1};
        System.out.println(thirdMax(nums));
    }
}
