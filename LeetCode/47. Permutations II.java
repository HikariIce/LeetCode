public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
		List<Integer> ele = new ArrayList<>();
		boolean[] flag = new boolean[nums.length];
		Arrays.sort(nums);
		permute(nums,0,res,ele,flag);
		return res;
    }
    
    public void permute(int[] nums, int n, List<List<Integer>> res,List<Integer> ele,boolean[] flag){
		
		for (int i = 0; i < nums.length; i++){
			if(flag[i] == false){
			    if (i!=0 && nums[i]==nums[i-1] && flag[i-1]==true) continue;
				ele.add(nums[i]);
				flag[i] = true;
				if (n == nums.length-1){
					res.add(new ArrayList<>(ele));
				} else permute(nums,n+1,res,ele,flag);
				flag[i] = false;
				ele.remove(ele.size()-1);
			}
		}
	}
}