public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
		
		if(matrix == null || matrix.length == 0) return res;
		if(matrix[0] == null || matrix[0].length == 0) return res;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int layer = (Math.min(m, n)+1)/2;
		
		for(int i = 0; i < layer; ++i){
			for(int j = i; j <= n-1-i; j++) 
				res.add(matrix[i][j]);
			for(int j = i+1; j <= m-1-i; j++) 
				res.add(matrix[j][n-1-i]);
			if(m-1-i > i)
				for(int j = n-2-i; j >= i; j--)
					res.add(matrix[m-1-i][j]);
			if(n-1-i > i)
				for(int j = m-2-i; j > i; j--)
					res.add(matrix[j][i]);
		}
		
		return res;
    }
}