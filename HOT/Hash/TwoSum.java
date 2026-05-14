package HOT.Hash;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(nums[0], 0);
        for(int i = 1; i < nums.length; i ++){
            int pair = target - nums[i];
            if(hm.get(pair) != null) {
                ans[0] = hm.get(pair);
                ans[1] = i;
            }else hm.put(nums[i], i);
        }
        return ans;
    }
}