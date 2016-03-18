class Solution {
public:
    int longestValidParentheses(string s) {
        stack<int> stk;
        int longest = 0,start = 0;
        if(s.length()==0) return 0;
        for(int i = 0;i<s.length();++i){
            if(s[i]=='(') stk.push(i);
            else{
                if(stk.empty()) start = i+1;
                else{
                    stk.pop();
                    if(stk.empty()) longest = max(longest,i-start+1);
                    else longest = max(longest,i-stk.top());
                }
            }
        }
        return longest;
    }
};