package HOT.SlideWindow;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // 使用数组记录字符上次出现的位置 (假设字符集为 ASCII)
        int[] lastSeen = new int[128];
        for (int i = 0; i < 128; i++) lastSeen[i] = -1;
        
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // 如果当前字符在当前窗口内出现过，移动左边界
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }
            
            // 更新字符最后出现的位置
            lastSeen[currentChar] = right;
            
            // 计算当前窗口长度并更新最大值
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}