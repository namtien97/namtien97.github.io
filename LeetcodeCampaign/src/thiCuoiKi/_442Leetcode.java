package thiCuoiKi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _442Leetcode {
    static public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], hashMap.get(nums[i])+1);
            }else {
                hashMap.put(nums[i], 1);
            }
        }
        for (Integer key: hashMap.keySet()) {
            if(hashMap.get(key)==2){
                list.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        for (Integer s : findDuplicates(arr)) {
            System.out.println(s);
        }
    }
}
