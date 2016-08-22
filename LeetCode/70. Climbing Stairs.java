public class Solution {
    public int climbStairs(int n) {
        int twoStep = 0;    //��n�����������n-2�Ĳ���
        int oneStep = 1;    //��n���һ������n-1�Ĳ���
        int total = 0;          //��ǰ��������f(n) = f(n-2) + f(n-1)
        
        for(int i = 1; i <= n; ++i){
            total = twoStep + oneStep;
            twoStep = oneStep;
            oneStep = total;
        }
        
        return total;
    }
}