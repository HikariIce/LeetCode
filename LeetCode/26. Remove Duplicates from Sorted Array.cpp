class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        int count = 1;
        if(nums.size()<=1) return nums.size();
        for(int i = 1;i<nums.size();++i){
            if(nums[i]!=nums[i-1]) nums[count++] = nums[i];
        }
        return count;
    }
};