vector<vector<int> > threeSum(vector<int>& nums) {
    vector<vector<int> > out;
    set<vector<int> > ret;
    if(nums.empty()) return out;
    sort(nums.begin(),nums.end());
    for(int i = 0;i<nums.size()-1;++i){
        int l = i+1,r = nums.size()-1;
        while(l<r){
            if(nums[i]+nums[l]+nums[r]==0){
                vector<int> v;
                v.push_back(nums[i]);
                v.push_back(nums[l]);
                v.push_back(nums[r]);
                ret.insert(v);
                ++l;
            }
            else if(nums[i]+nums[l]+nums[r]<0) {
                ++l;
            }
            else{
                --r;
            }
        }
    }
    set<vector<int> >::iterator it;
    for(it=ret.begin();it!=ret.end();it++){
        out.push_back(*it);
    }

    return out;
}