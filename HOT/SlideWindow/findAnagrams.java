package HOT.SlideWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) return ans;

        // 两个频率数组
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 1. 初始化第一个窗口
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // 如果第一个窗口匹配
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // 2. 开始滑动窗口
        // i 是新进入窗口的字符索引，i - pLen 是要移出窗口的字符索引
        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++;          // 进一个
            sCount[s.charAt(i - pLen) - 'a']--;   // 出一个

            // 3. 比较当前窗口
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - pLen + 1);
            }
        }

        return ans;
    }
}