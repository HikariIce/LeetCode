public class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String ret = "";
        
        String str = countAndSay(n-1) + "*";
        int count = 1;
        int len = str.length();
        for(int i=0;i<len-1;++i){
            if(str.charAt(i)==str.charAt(i+1)) ++count;
            else{
                ret = ret + count + str.charAt(i);
                count = 1;
            }
        }
        
        return ret;
    }
}