class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int i = nums.size()-1;
        while(i>=0 && nums[i]>=target) --i;
        return ++i;
    }
};