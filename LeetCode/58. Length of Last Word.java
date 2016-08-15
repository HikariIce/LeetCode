public class Solution {
    public int lengthOfLastWord(String s) {
        int cur = s.length()-1;
        int count = 0;
        while(cur >= 0 && s.charAt(cur) == ' ') cur--;
        for(; cur >= 0; cur--){
            if(s.charAt(cur) != ' ') count++;
            else break;
        }
        return count;
    }
}