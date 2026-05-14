package HOT.TwoP;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int j = 0; // 慢指针
        //第一次遍历：把所有非零元素挪到数组前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        //第二次遍历：从 j 位置开始，后面的全部补零
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}