class Solution {
public:
    int search(vector<int>& nums, int target) {
        // 初始问题
        int l = 0, r = nums.size() - 1;
        // 不断重复来缩小问题规模
        while (l < r) {
            // 取中点，分情况讨论
            int m = (l + r) / 2;
            // 情况0
            if (target == nums[m]) return m;
            // 情况1
            if (nums[l] < nums[r]) {
                if (target > nums[m]) l = m + 1;
                if (target < nums[m]) r = m - 1;
            }
            else {
                // 情况2.1
                if (nums[m] >= nums[l]) {
                    if (target > nums[m] || target < nums[l]) {
                        l = m + 1;
                    }
                    else {
                        r = m - 1;
                    }
                }
                // 情况2.2
                else {
                    if (target < nums[m] || target > nums[r]) {
                        r = m - 1;
                    }
                    else {
                        l = m + 1;
                    }
                }
            }
        }
        // 计算答案
        if (nums[l] == target) return l;
        return -1;
    }
};