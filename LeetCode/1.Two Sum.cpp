#include <iostream>
#include <vector>
#include <map>
using namespace std;


class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        map<int, int> mp;
        vector<int> ans;
        for(int i = 0; i < numbers.size(); i ++)
        {
            if(mp.count(target - numbers[i]))
            {
                ans.push_back(mp[target - numbers[i]] + 1);
                ans.push_back(i + 1);
                break;
            }
            if(!mp.count(numbers[i])) mp[numbers[i]] = i;
        }
        return ans;
    }
};

int main()
{
    vector<int> v;
    vector<int> r;
    v.push_back(2);
    v.push_back(7);
    v.push_back(11);
    v.push_back(15);
    r = s.twoSum(v,9);
    cout<<r[0]<<" "<<r[1];

    return 0;
}
