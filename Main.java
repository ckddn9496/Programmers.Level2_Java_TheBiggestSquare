public class Main {

	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		// return 9;
		
//		int[][] board = {{0,0,1,1},{1,1,1,1}};
//		// return 4;
		
		System.out.println(new Solution().solution(board));
	}

}

class Solution {
	public int solution(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		int max = 0;

		if (row < 2 || col < 2) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] == 1)
						return 1;
				}
			}
			return 0;
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (board[i][j] == 1) {
					board[i][j] = Math.min(Math.min(board[i-1][j], board[i-1][j-1]), board[i][j-1]) + 1;
					if (max < board[i][j])
						max = board[i][j];
				}
			}
		}
		return max*max;
	}
	
}