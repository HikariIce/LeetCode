class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int INF = 100000;
        int len = nums.size();
        if(len<=1) return;
        int i = len-1;
        while(i>0 && nums[i-1]>=nums[i]) --i;
        if(i==0) {
            reverse(nums.begin(),nums.end());
            return;
        }
        int t = i-1;
        int mininmax = INF;
        while(i<len && nums[i]>nums[t]) {
            mininmax = min(mininmax,nums[i]);
            ++i;
        }
        swap(nums[t],nums[i-1]);
        reverse(nums.begin()+t+1,nums.end());
        return;
    }
};