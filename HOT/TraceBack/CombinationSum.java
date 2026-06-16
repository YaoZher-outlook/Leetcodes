class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, target, 0);
        return ans;
    }
    private void bt(int[] candidates, int subtg, int index){
        if(subtg == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(subtg - candidates[i] < 0) break;
            temp.add(candidates[i]);
            bt(candidates, subtg - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}