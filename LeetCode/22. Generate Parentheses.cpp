class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        set<string> filter;
        
        if(n<1) return ret;
        if(n==1) {
            ret.push_back("()");
            return ret;
        }
        
        vector<string> pre = generateParenthesis(n-1);
        for(int i=0;i<pre.size();++i){
            int len = pre[i].size();
            for(int j=0;j<=len;++j){
                string str = pre[i].substr(0,j)+"()"+pre[i].substr(j,len);
                if(filter.count(str)==0){
                    filter.insert(str);
                    ret.push_back(str);
                }
            }
        }
        
        return ret;
    }
};