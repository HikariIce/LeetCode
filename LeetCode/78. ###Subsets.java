public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int n = (int)Math.pow(2, nums.length);
		
		Arrays.sort(nums);
		
		for(int i = 0; i < n; ++i){
			List<Integer> ele = new ArrayList<>();
			for(int j = 0; j < nums.length; ++j){
				if(((1 << j) & i) != 0)
					ele.add(nums[j]);
			}
			res.add(ele);
		}
		
		return res;
    }
}