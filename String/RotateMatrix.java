package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Rotate an NxN matrix clockwise by 90 degree
 * 
 * For example:
 * 
 * input: 1 2 3
 *        4 5 6
 *        7 8 9
 *        
 * output: 7 4 1
 *         8 5 2
 *         9 6 3
 */

public class RotateMatrix {
	
	public static int[][] spiralMatrix(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix.length];
		spiralAdd(matrix, 0, matrix.length, res);
		return res;
	}
	
	public static void spiralAdd(int[][] matrix, int offset, int size, int[][] res) {
		
		//base case
		if(size == 1) {
			res[offset][offset] = matrix[offset][offset];
			return;
		}
		
		//upper row
		for(int i = 0; i < size - 1; i++) {
			res[i + offset][matrix.length - 1 - offset] = matrix[offset][i + offset];
		}
		
		//right column
		for(int i = 0; i < size - 1; i++) {
			res[matrix.length - 1 - offset][matrix.length - 1 - offset - i] = matrix[i + offset][matrix.length - 1 - offset];
		}
		
		//bottom row
		for(int i = 0; i < size - 1; i++) {
			res[matrix.length - 1 - offset - i][offset] = matrix[matrix.length - 1 - offset][matrix.length - 1 - offset - i];
		}
		
		//left column
		for(int i = 0; i < size - 1; i++) {
			res[offset][i + offset] = matrix[matrix.length - 1 - offset - i][offset];
		}
		
		//Recursive rules
		spiralAdd(matrix, offset + 1, size - 2, res);
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, 
				          {4, 5, 6}, 
				          {7, 8, 9}};
		int[][] res = spiralMatrix(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(res[i][j] + " ");
			}
		}
	}

}
