public class Solution {
    int total;
    public int totalNQueens(int n) {
		int[] queenList = new int[n];
		placeQueen(n, 0, queenList);
		return total;
    }
	
	public void placeQueen(int n, int row, int[] queenList){
		if(row == n){
			total += 1;
		}
		
		for (int col = 0; col < n; col++){
			if (isValid(queenList,row,col)){
				queenList[row] = col;
				placeQueen(n, row+1, queenList);
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