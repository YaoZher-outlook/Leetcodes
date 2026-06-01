package HOT.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // 别忘了处理 k > n 的情况
        if (k == 0) return;

        // 1. 翻转整个数组
        reverse(nums, 0, n - 1);
        // 2. 翻转前 k 个元素
        reverse(nums, 0, k - 1);
        // 3. 翻转剩余的 n-k 个元素
        reverse(nums, k, n - 1);
    }

    // 提取公共的反转逻辑
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}