public class Solution {
    public int jump(int[] nums){
		int ret = 0;
		int lastMax = 0;
		int curMax = 0;
		
		if(nums.length == 0 || nums.length == 1) return ret;
		curMax = nums[0];
		for(int i = 1; i < nums.length; ++i){
			if(i > curMax) return -1;
			if(i > lastMax){
				lastMax = curMax;
				++ret;
			}
			curMax = Math.max(curMax, i + nums[i]);
		}
		
		return ret;
	}
}