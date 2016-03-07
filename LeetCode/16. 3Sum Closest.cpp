class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int ret = 999999;
        sort(nums.begin(),nums.end());
        for(int i = 0;i<nums.size()-1;++i){
            while(i>0 && i<nums.size()-1 && nums[i]==nums[i-1]) i++; //skip same number
            int l = i+1,r = nums.size()-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return target;
                }
                else if(sum<target) {
                    ++l;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    if(target-sum<abs(target-ret)) ret = sum;
                }
                else{
                    --r;
                    while(l<r && nums[r]==nums[r+1]) r--;
                    if(sum-target<abs(target-ret)) ret = sum;
                }
            }
        }
        return ret;
    }
};