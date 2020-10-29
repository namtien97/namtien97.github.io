public class ThirdMaxiumNumber_414 {
    public static int thirdMax(int[] nums) {
        int result = 0;
        int count = 1;
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
                int indexMax = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[indexMax]) {
                        indexMax = j;
                    }
                }
                if (indexMax != i) {
                    int t = nums[i];
                    nums[i] = nums[indexMax];
                    nums[indexMax] = t;
                }
            }
            int j = 1;
            for (int i = 0; i < nums.length; i++) {
                while (true) {
                    if (j == nums.length) {
                        break;
                    }
                    if (nums[i] != nums[j]) {
                        nums[i + 1] = nums[j];
                        count++;
                        break;
                    } else {
                        j++;
                    }
                }
            }
        }
        if(count == 2){
            return nums[0];
        }
        return nums[2];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(thirdMax(nums));
    }
}
