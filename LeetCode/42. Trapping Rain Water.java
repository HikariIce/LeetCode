public class Solution {
    public int trap(int[] height) {
        int ret = 0;
        int l = 0, r = height.length-1;
        while(l<r){
        	int minHeight = Math.min(height[l],height[r]);
        	if(height[l]==minHeight)
        		while(++l < r && height[l] < minHeight)
        			ret += minHeight-height[l];
        	else
        		while(--r > l && height[r] < minHeight)
        			ret += minHeight-height[r];
        }
        
        return ret;
    }
}