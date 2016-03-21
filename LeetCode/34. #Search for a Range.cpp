class Solution {
public:
    int searchLow(vector<int>& a,int s,int t,int tar){
        if(s>t) return s;   // s>t !!!     not s==t !!!
        int m = (s+t)/2;
        if(tar>a[m]) return searchLow(a,m+1,t,tar);
        else return searchLow(a,s,m-1,tar);
    }
    
    int searchHigh(vector<int>& a,int s,int t,int tar){
        if(s>t) return t;   // s>t !!!     not s==t !!!
        int m = (s+t)/2;
        if(tar<a[m]) return searchHigh(a,s,m-1,tar);
        else return searchHigh(a,m+1,t,tar);
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ret(2,-1);

        int len = nums.size();
        if(len==0) return ret;
        int lo = searchLow(nums,0,len-1,target);
        int hi = searchHigh(nums,0,len-1,target);
        if(lo<=hi){
            ret.clear();
            ret.push_back(lo);
            ret.push_back(hi);
            return ret;
        }
        return ret;
    }
    
    
};