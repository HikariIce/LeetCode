public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> ele = new ArrayList<>();
		boolean[] flag = new boolean[nums.length];
		permute(nums,0,res,ele,flag);
		return res;
    }
	
	public static void permute(int[] nums, int n, List<List<Integer>> res,List<Integer> ele,boolean[] flag){
		
		for (int i = 0; i < nums.length; i++){
			if(flag[i] == false){
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