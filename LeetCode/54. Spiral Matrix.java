public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;
        int startx = 0,starty = 0,endx = matrix[0].length-1,endy = matrix.length-1;
        
        while(startx <= endx && starty <= endy){
            for(int i = startx;i<=endx && starty <= endy;i++){// 该题这里需要判断下 starty endy 的边界，不然容易重复加入list
                ans.add(matrix[starty][i]);
            }
            starty++;
            
            for(int i = starty;i<=endy && startx <= endx;i++){
                 ans.add(matrix[i][endx]);
            }
            endx--;
            
            for(int i = endx;i>=startx && starty <= endy;i--){
                ans.add(matrix[endy][i]);
            }
            endy--;
            
            for(int i = endy;i>=starty && startx <= endx;i--){
                ans.add(matrix[i][startx]);
            }
            startx++;
        }
        return ans;
    }
}