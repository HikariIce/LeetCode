class Solution {
public:
    int divide(int dividend, int divisor) {
        long long MAX_INT = 2147483647;
        long long a = abs((double)dividend);  
        long long b = abs((double)divisor);  
          
        long long ret = 0;  
        while (a >= b) {  
            long long c = b;  
            for (int i = 0; a >= c; ++i, c <<= 1) {  
                a -= c;  
                ret += 1 << i;
            }  
        }  
        bool flag = !((dividend^divisor)>>31);  
        if(flag){
            if(ret>MAX_INT) return MAX_INT;
            return ret;
        }
        else{
            if(ret>MAX_INT+1) return -MAX_INT-1;
            return -ret;
        }
    }
};