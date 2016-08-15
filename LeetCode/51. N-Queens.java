public class Solution {
    public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		int[] queenList = new int[n];
		placeQueen(n, 0, queenList, res);
		return res;
    }
	
	public void placeQueen(int n, int row, int[] queenList, List<List<String>> res){
		if(row == n){
			List<String> list = new ArrayList<>();
			for(int i = 0; i < n; i++){
				String s = "";
				for(int j = 0; j < n; j++){
					if(queenList[i] == j) s += "Q";
					else s += ".";
				}
				list.add(s);
			}
			res.add(list);
			return;
		}
		
		for (int col = 0; col < n; col++){
			if (isValid(queenList,row,col)){
				queenList[row] = col;
				placeQueen(n, row+1, queenList, res);
			}
		}
	}
	
	public boolean isValid(int[] queenList, int row, int col){
		for(int posRow = 0; posRow < row; posRow++){
			int posCol = queenList[posRow];
			if(posCol == col || posRow - posCol == row - col 
					|| posRow + posCol == row + col ) 
				return false;
		}
		return true;
	}
}