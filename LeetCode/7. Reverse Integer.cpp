class Solution {
public:
    int reverse(int x) {
        int flag = 0; //0Õı1¸º
        int xx = x;
        int t;
        if(x<0) {
        	flag = 1;
        	xx = -x;
        }

        int ret=0;
        while(xx!=0){
        	t = xx%10;

            if(ret!=0){
            	if((2147483647-t)/10<ret)
            		return 0;
            	if(flag!=0){
            		if((-2147483648+t)/10>-ret)
                		return 0;
            	}
            }
            xx = xx/10;
            ret = ret*10 + t;
        }
        if (flag!=0) return -ret;
        return ret;
    }
};