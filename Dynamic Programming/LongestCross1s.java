package leetcode;

/**
 * Longest Cross Of 1s
 * 
 * Given a matrix that contains only 1s and 0s, find the largest cross which
 * contains only 1s, with the same arm lengths and the four arms joining at the
 * central point.
 * 
 * Return the arm length of the largest cross.
 * 
 * Assumptions
 * 
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0. Examples
 * 
 * { {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1} }
 * 
 * the largest cross of 1s has arm length 2.
 */

public class LongestCross1s {
	
	public static int findLargest(int[][] matrix) {
		
		//corner case
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		
		int[][] left = fromLeftToRight(matrix, matrix.length, matrix[0].length);
		int[][] right = fromRightToLeft(matrix, matrix.length, matrix[0].length);
		int[][] top = fromTopToBottom(matrix, matrix.length, matrix[0].length);
		int[][] bottom = fromBottomToTop(matrix, matrix.length, matrix[0].length);
		
		int combineMin = 0;
		int globalMax = Integer.MIN_VALUE;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				combineMin = Math.min(Math.min(left[i][j], right[i][j]), Math.min(top[i][j], bottom[i][j]));
				globalMax = Math.max(combineMin, globalMax);
			}
		}
		return globalMax;
	}
	
	private static int[][] fromLeftToRight(int[][] matrix, int row, int col) {
		
		int[][] left = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 1) {
					if(j == 0) {
						left[i][j] = 1;
					}else {
						left[i][j] = 1 + left[i][j - 1];
					}
				}
			}
		}
		return left;
	}
	
	private static int[][] fromRightToLeft(int[][] matrix, int row, int col) {
		
		int[][] right = new int[row][col];
		for(int i = row - 1; i >= 0; i--) {
			for(int j = col - 1; j >= 0; j--) {
				if(matrix[i][j] == 1) {
					if(j == col - 1) {
						right[i][j] = 1;
					}else {
						right[i][j] = 1 + right[i][j + 1];
					}
				}
			}
		}
		return right;
	}
	
	private static int[][] fromTopToBottom(int[][] matrix, int row, int col) {
		
		int[][] top = new int[row][col];
		for(int j = 0; j < col; j++) {
			for(int i = 0; i < row; i++) {
				if(matrix[i][j] == 1) {
					if(i == 0) {
						top[i][j] = 1;
					}else {
						top[i][j] = 1 + top[i - 1][j];
					}
				}
			}
		}
		return top;
	}
	
	private static int[][] fromBottomToTop(int[][] matrix, int row, int col) {
		
		int[][] bottom = new int[row][col];
		for(int j = col - 1; j >= 0; j--) {
			for(int i = row - 1; i >= 0; i--) {
				if(matrix[i][j] == 1) {
					if(i == row - 1) {
						bottom[i][j] = 1;
					}else {
						bottom[i][j] = 1 + bottom[i + 1][j];
					}
				}
			}
		}
		return bottom;
	}
	
	public static void main(String[] args) {
		//int[][] matrix = { { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 } };
		int[][] matrix = {{0, 1, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 0, 0}};
		LongestCross1s ls = new LongestCross1s();
		System.out.println(ls.findLargest(matrix));
	}
}
