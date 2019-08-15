package leetcode;

/**
 * Longest "X" Of 1s
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
 *  1 0 1
 *  0 1 0
 *  1 0 1
 * 
 * the largest "X" of 1s has arm length 2.
 */

public class LongestX1s {
	
	public static int findLargest(int[][] matrix) {
		
		//corner case
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		
		int[][] left = fromLeftUP(matrix, matrix.length, matrix[0].length);
		int[][] right = fromRightUP(matrix, matrix.length, matrix[0].length);
		int[][] top = fromLeftBottom(matrix, matrix.length, matrix[0].length);
		int[][] bottom = fromRightBottom(matrix, matrix.length, matrix[0].length);
		
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
	
	private static int[][] fromLeftUP(int[][] matrix, int row, int col) {
		
		int[][] lu = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 1) {
					if(i == 0 || j == 0) {
						lu[i][j] = 1;
					}else {
						lu[i][j] = 1 + lu[i - 1][j - 1];
					}
				}
			}
		}
		return lu;
	}
	
	private static int[][] fromRightUP(int[][] matrix, int row, int col) {
		
		int[][] ru = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = col - 1; j >= 0; j--) {
				if(matrix[i][j] == 1) {
					if(j == col - 1 || i == 0) {
						ru[i][j] = 1;
					}else {
						ru[i][j] = 1 + ru[i - 1][j + 1];
					}
				}
			}
		}
		return ru;
	}
	
	private static int[][] fromLeftBottom(int[][] matrix, int row, int col) {
		
		int[][] lb = new int[row][col];
		for(int j = 0; j < col; j++) {
			for(int i = row - 1; i >= 0; i--) {
				if(matrix[i][j] == 1) {
					if(j == 0 || i == row - 1) {
						lb[i][j] = 1;
					}else {
						lb[i][j] = 1 + lb[i + 1][j - 1];
					}
				}
			}
		}
		return lb;
	}
	
	private static int[][] fromRightBottom(int[][] matrix, int row, int col) {
		
		int[][] rb = new int[row][col];
		for(int j = col - 1; j >= 0; j--) {
			for(int i = row - 1; i >= 0; i--) {
				if(matrix[i][j] == 1) {
					if(i == row - 1 || j == col - 1) {
						rb[i][j] = 1;
					}else {
						rb[i][j] = 1 + rb[i + 1][j + 1];
					}
				}
			}
		}
		return rb;
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		//int[][] matrix = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
		LongestX1s xs = new LongestX1s();
		System.out.println(xs.findLargest(matrix));
	}
}
