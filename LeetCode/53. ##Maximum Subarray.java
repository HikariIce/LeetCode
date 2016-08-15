public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
        int max = nums[0];
        int curMax = nums[0];
        for(int i = 1; i < nums.length; i++){
        	if(curMax >= 0)
        		curMax += nums[i];
        	else
        		curMax = nums[i];
        	if(curMax > max) max = curMax;
        }
        return max;
    }
}