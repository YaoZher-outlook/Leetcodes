package HOT.TraceBack;
import java.util.ArrayList;


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 初始调用，从索引 0 开始
        backtracking(nums, 0, path, ans);
        return ans;
    }

    private void backtracking(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> ans) {
        // 1. 收集结果：每一个路径节点都是一个子集
        ans.add(new ArrayList<>(path));

        // 2. 终止条件：如果索引超过数组长度，自然结束循环
        for (int i = startIndex; i < nums.length; i++) {
            // 3. 处理节点
            path.add(nums[i]);
            
            // 4. 递归：传入 i + 1，保证不重复选择当前及之前的元素
            backtracking(nums, i + 1, path, ans);
            
            // 5. 回溯：撤销选择，回到父节点状态
            path.remove(path.size() - 1);
        }
    }
}