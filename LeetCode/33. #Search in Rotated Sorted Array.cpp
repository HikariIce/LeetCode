class Solution {
public:
    int search(vector<int>& nums, int target) {
        // ��ʼ����
        int l = 0, r = nums.size() - 1;
        // �����ظ�����С�����ģ
        while (l < r) {
            // ȡ�е㣬���������
            int m = (l + r) / 2;
            // ���0
            if (target == nums[m]) return m;
            // ���1
            if (nums[l] < nums[r]) {
                if (target > nums[m]) l = m + 1;
                if (target < nums[m]) r = m - 1;
            }
            else {
                // ���2.1
                if (nums[m] >= nums[l]) {
                    if (target > nums[m] || target < nums[l]) {
                        l = m + 1;
                    }
                    else {
                        r = m - 1;
                    }
                }
                // ���2.2
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
        // �����
        if (nums[l] == target) return l;
        return -1;
    }
};