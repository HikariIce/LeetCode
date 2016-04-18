public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
		int maxJump = nums[0];
		for(int i = 1; i < nums.length; ++i){
			if(maxJump > 0){
				--maxJump;
				maxJump = Math.max(maxJump, nums[i]);
			} else{
				return false;
			}
		}
		return true;
    }
}