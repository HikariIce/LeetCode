class Solution {
public:
    int romanToInt(string s) {
        map<char,int> dict ;
        int ret = 0;
        dict['I'] = 1;
        dict['V'] = 5;
        dict['X'] = 10;
        dict['L'] = 50;
        dict['C'] = 100;
        dict['D'] = 500;
        dict['M'] = 1000;
        for(int i=0;i<s.size();++i){
            if((i+1<s.size())&&(dict[s[i]]<dict[s[i+1]])) {
               ret += dict[s[i+1]]-dict[s[i]];
               ++i;
            }
            else
                ret += dict[s[i]];
        }
        return ret;
    }
};