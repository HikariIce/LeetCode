class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int> > ret;
        if(nums.empty()) return ret;
        sort(nums.begin(),nums.end());
        for(int i = 0;i<nums.size()-1;++i){
            while(i>0 && i<nums.size()-1 && nums[i]==nums[i-1]) i++; //skip same number
            int l = i+1,r = nums.size()-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    vector<int> v;
                    v.push_back(nums[i]);
                    v.push_back(nums[l]);
                    v.push_back(nums[r]);
                    ret.push_back(v);
                    ++l;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }
                else if(nums[i]+nums[l]+nums[r]<0) {
                    ++l;
                    while(l<r && nums[l]==nums[l-1]) l++;
                }
                else{
                    --r;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }
            }
        }
        return ret;
    }
};