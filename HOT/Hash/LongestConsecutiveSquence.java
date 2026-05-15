package HOT.Hash;
import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int maxLen = 1;
        int currentLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue; // 跳过重复数字
            
            if (nums[i] == nums[i - 1] + 1) {
                currentLen++; // 连续，增加当前长度
            } else {
                maxLen = Math.max(maxLen, currentLen); // 记录最长值
                currentLen = 1; // 发生断裂，重置当前长度
            }
        }
        return Math.max(maxLen, currentLen);
    }
}