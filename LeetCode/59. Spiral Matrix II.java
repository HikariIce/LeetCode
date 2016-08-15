public class Solution {
    public int[][] generateMatrix(int n) {
        int startx = 0,starty = 0,endx = n-1,endy = n-1;
        int[][] ans = new int[n][n];
        int count = 1;
        while(startx <= endx && starty <= endy){
        for(int i = startx;i<=endx;i++){
            ans[starty][i] = count++;
        }
        starty++;
    
        for(int i = starty;i<=endy;i++){
            ans[i][endx] = count++;
        }
        endx--;
        
        for(int i = endx;i>=startx;i--){
            ans[endy][i] = count++;
        }
        endy--;
        
        for(int i = endy;i>=starty;i--){
            ans[i][startx] = count++;
        }
        startx++;
    }
    return ans;
    }
}