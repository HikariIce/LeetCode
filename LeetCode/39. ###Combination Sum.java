public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0,0,temp, res);   
        return res;
    }
    public void findSum(int[] candidates, int target, int sum, int level,List<Integer> temp, List<List<Integer>> res){
        if(sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if(sum > target) {
            return;
        } else {
            for(int i=level;i<candidates.length;i++) {
                temp.add(candidates[i]);
                findSum(candidates, target, sum+candidates[i], i, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
}