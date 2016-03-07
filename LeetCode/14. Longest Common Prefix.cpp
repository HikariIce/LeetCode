class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ret="";
        if(strs.size()==0) return ret;
        else if(strs.size()==1) return strs[0];
        else{
            int id = 0;
            while(true){
                for(int i=0;i<strs.size();++i){
                    if((id<strs[i].size()) && strs[i][id]==strs[0][id]){
                        if(i==strs.size()-1){
                            ret += strs[0][id];
                            ++id;
                        }
                    }
                    else 
                        return ret;
                }
            }
        }
    }
};