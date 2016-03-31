public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
		int[] ret = new int[num1.length()+num2.length()-1];
		String rets = "";
        for(int i = num1.length()-1; i >= 0; --i)
        	for(int j = num2.length()-1; j >= 0; --j)
        		ret[i+j] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        int c = 0;
        for(int i = ret.length-1; i >= 0; --i){
        	c = c + ret[i];
        	ret[i] = c % 10;
        	c = c/10;
        	rets = ret[i] + rets;
        }
        if(c==0)
        	return rets;
        else
        	return c+rets;
    }
}