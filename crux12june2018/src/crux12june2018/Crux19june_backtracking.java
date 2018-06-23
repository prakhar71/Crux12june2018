package crux12june2018;

public class Crux19june_backtracking {

	public static void main(String[] args) {
		// nqueen(new boolean[4][4], 0, "");

		/*
		 * int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0
		 * }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0,
		 * 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5,
		 * 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		 * 
		 * boolean res = sudokuSolver(board, 0, 0); if(res) { display(board); } else {
		 * System.out.println("not possible"); }
		 */

		nKnights(new boolean[4][4], 0, 0, "");

	}

	public static void nKnights(boolean[][] board, int row, int col, String ans) {

		if (col >= board[0].length) {
			nKnights(board, row + 1, 0, ans);
			return;
		}

		if (row >= board.length) {
			System.out.println(ans);
			return;
		}

		if (isItSafeNKnights(board, row, col)) {

			board[row][col] = true;
			nKnights(board, row, col + 1, ans + "{" + row + "," + col + "}");
		} else {
			nKnights(board, row, col + 1, ans);
		}

	}

	public static boolean isItSafeNKnights(boolean board[][], int row, int col) {
		if ((row + 2) < board.length && (col + 1) < board[0].length)
			if (board[row + 2][col + 1] == true) {
				return false;
			}

		if ((row + 2) < board.length && (col - 1) > 0)
			if (board[row + 2][col - 1] == true) {
				return false;
			}

		if ((row - 2) > 0 && (col - 1) > 0) {

			if (board[row - 2][col - 1] == true) {
				return false;
			}
		}

		if ((row - 2) > 0 && (col + 1) < board[0].length)
			if (board[row - 2][col + 1] == true) {
				return false;
			}
		// opp
		if ((row + 1) < board.length && (col + 2) < board[0].length)
			if (board[row + 1][col + 2] == true) {
				return false;
			}

		if ((row - 1) > 0 && (col + 2) < board[0].length)
			if (board[row - 1][col + 2] == true) {
				return false;
			}

		if ((row - 1) > 0 && (col - 2) > 0)
			if (board[row - 1][col - 2] == true) {
				return false;
			}

		if ((row + 1) < board.length && (col - 2) > 0)
			if (board[row + 1][col - 2] == true) {
				return false;
			}

		return true;

	}

	public static void display(int board[][]) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void nqueen(boolean board[][], int row, String ans) {
		int col;

		if (row == board.length) {
			System.out.println(ans);
			return;
		}

		for (col = 0; col < board[0].length; col++) {

			if (isitSafe(board, row, col)) {
				board[row][col] = true;
				nqueen(board, row + 1, ans + "{" + row + "," + col + "}");
				board[row][col] = false;
			}

		}
	}

	public static boolean isitSafe(boolean board[][], int row, int col) {

		int r = row - 1;
		int c = col;

		// vertically up

		while (r >= 0) {

			if (board[r][c] == true) {
				return false;

			}

			r--;
		}

		// diagnolly left

		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {

			if (board[r][c] == true) {
				return false;

			}

			r--;
			c--;
		}

		// diagonally right

		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {

			if (board[r][c] == true) {
				return false;

			}

			r--;
			c++;
		}

		return true;

	}

	public static boolean sudokuSolver(int board[][], int row, int col) {

		if (row == board.length) {
			return true;
		}

		if (col == board[0].length) {
			return sudokuSolver(board, row + 1, 0);
		}

		if (board[row][col] != 0) {
			return sudokuSolver(board, row, col + 1);
		}

		for (int i = 1; i <= 9; i++) {

			if (isItSafe(board, row, col, i)) {
				board[row][col] = i;
				boolean res = sudokuSolver(board, row, col + 1);
				if (res) {
					return true;
				}

				board[row][col] = 0;
			}
		}

		return false;

	}

	public static boolean isItSafe(int board[][], int row, int col, int n) {
		int i, j;
		// row check
		for (i = 0; i < board[0].length; i++) {
			if (n == board[row][i]) {
				return false;
			}
		}

		// col check

		for (i = 0; i < board.length; i++) {
			if (n == board[i][col]) {
				return false;
			}
		}

		// grid

		int rsp, csp;

		rsp = row - (row % 3);
		csp = col - (col % 3);

		for (i = rsp; i < rsp + 3; i++) {
			for (j = csp; j < csp + 3; j++) {

				if (n == board[i][j])
					return false;
			}
		}

		return true;
	}

}
