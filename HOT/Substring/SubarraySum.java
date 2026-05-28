package HOT.Substring;

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map stores (running_sum, frequency_of_this_sum)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a sum of 0 has happened exactly 1 time (before we add any elements)
        map.put(0, 1);
        
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Add current element to running sum
            
            // Check if (sum - k) exists in the map
            // If it does, it means there is a subarray ending here that sums to k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Add the current running sum to the map for future elements to use
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}