package HOT.Hash;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//BY sorting, time complexity O(nlogn), space complexity O(1)

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums.length == 0) return 0;
//         Arrays.sort(nums);

//         int maxLen = 1;
//         int currentLen = 1;

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i - 1]) continue; // 跳过重复数字
            
//             if (nums[i] == nums[i - 1] + 1) {
//                 currentLen++; // 连续，增加当前长度
//             } else {
//                 maxLen = Math.max(maxLen, currentLen); // 记录最长值
//                 currentLen = 1; // 发生断裂，重置当前长度
//             }
//         }
//         return Math.max(maxLen, currentLen);
//     }
// }

//BY HashSet, time complexity O(n), space complexity O(n)

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;

        for (int num : set) {
            // 只有当 num 是一个序列的起点时，才开始计数
            // 如果 set 里有 num - 1，说明 num 不是起点，跳过
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                // 往后数有多少个连续数字
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }
}