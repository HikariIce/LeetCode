public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0,temp, res);   
        return res;
    }
    public void findSum(int[] candidates, int target, int index,List<Integer> temp,  List<List<Integer>> res){
        for(int i=index;i<candidates.length;i++) {
            List<Integer> tt = new ArrayList<>(temp);
            if(candidates[i] == target) {
                tt.add(candidates[i]);
                if(!res.contains(tt)) res.add(tt);
                return;
            } else if(candidates[i] > target) {
                return;
            } else {
                tt.add(candidates[i]);
                findSum(candidates, target-candidates[i], i+1, tt, res);
            }
        }
    }
}