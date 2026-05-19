package HOT.TwoP;

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int fmax = 0;

        while (i < j) {
            // 计算当前面积
            int currentArea = (j - i) * Math.min(height[i], height[j]);
            fmax = Math.max(fmax, currentArea);

            // 移动较矮的那一侧
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return fmax;
    }
}