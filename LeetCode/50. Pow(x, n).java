public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
		if (n == 1) return x;
		
		double res;
		
		if (n == Integer.MIN_VALUE) return 1/(myPow(x, Integer.MAX_VALUE)*x);
		
		int absn = Math.abs(n);
		
		if ((absn & 0x1) == 1) {
			double temp = myPow(x, absn >> 1);
			res = temp * temp * x;
		} else {
			double temp = myPow(x, absn >> 1);
			res = temp * temp;
		}
		
		if (n < 0) res = 1/res;
        return res;
    }
}