public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        
        int i = 1;
        int j = x;
        while(i <= j){
        	int mid = (i+j)/2;
        	int t = x / mid - mid;
        	if(t == 0) return mid;
        	else if(t > 0){
        		i = mid + 1;
        	}else{
        		j = mid - 1;
        	}
        }
        return (int)j;
    }
}