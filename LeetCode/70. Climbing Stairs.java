public class Solution {
    public int climbStairs(int n) {
        int twoStep = 0;    //和n相差两步，即n-2的步数
        int oneStep = 1;    //和n相差一步，即n-1的步数
        int total = 0;          //当前步数，即f(n) = f(n-2) + f(n-1)
        
        for(int i = 1; i <= n; ++i){
            total = twoStep + oneStep;
            twoStep = oneStep;
            oneStep = total;
        }
        
        return total;
    }
}