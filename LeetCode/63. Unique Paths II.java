public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] path = new int[m][n];  
        
        for (int i = 0; i < m; ++i) {
            if(obstacleGrid[i][0] != 1)
                path[i][0] = 1;
            else{
                for(int j=i; j < m; j++)
                    path[i][0] = 0;
                break;
            } 
        } 
        
  
        for (int i = 1; i < n; ++i) { 
            if(obstacleGrid[0][i] != 1)
                path[0][i] = 1;
            else{
                for(int j=i; j < m; j++)
                    path[0][i] = 0;
                break;
            } 
        }  
  
        for (int i = 1; i < m; ++i)  
            for (int j = 1; j < n; ++j) { 
                if(obstacleGrid[i][j] != 1)
                    path[i][j] = path[i][j - 1] + path[i - 1][j];  
                else
                    path[i][j] = 0;
            }  
  
        return path[m - 1][n - 1];  
    }
}