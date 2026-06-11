package HOT.TraceBack;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 用于存放当前正在构建的排列路径
        List<Integer> path = new ArrayList<>();
        // 记录数组中的元素是否已经被使用过
        boolean[] used = new boolean[nums.length];
        
        // 开始回溯
        backtrack(nums, used, path, res);
        
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            // 注意：这里必须 new 一个新的 ArrayList 将当前 path 拷贝进去
            // 因为 path 变量指向的内存地址自始至终是同一个，如果直接加 path，后续的修改会影响结果
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择：如果当前元素已经被加入到了 path 中，则跳过
            if (used[i]) {
                continue;
            }

            // 做选择：将该元素加入路径，并标记为已使用
            path.add(nums[i]);
            used[i] = true;

            // 进入下一层决策树
            backtrack(nums, used, path, res);

            // 撤销选择：将刚刚加入的元素移除，并将其标记恢复为未使用
            // 这样才能在下一次循环中把它放到其他位置
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}