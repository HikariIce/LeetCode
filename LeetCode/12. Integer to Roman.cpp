class Solution {
public:
    string intToRoman(int num) {
        string roman[4][10] = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        };
        string ret = "";
        int pos = 1000,dit=3;
        while(num>0){
            if(num/pos != 0) ret += roman[dit][num/pos];
            num = num%pos;
            pos /= 10;
            dit--;
        }
        return ret;
    }
};