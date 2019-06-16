package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of N x N elements(N rows, N columns),
 * return all elements of the matrix in spiral order.
 * 
 * */

public class SpiralMatrixI {
	
	public static List<Integer> spiralMatrix(int[][] matrix) {
		List<Integer> res = new LinkedList<>();
		spiralAdd(matrix, 0, matrix.length, res);
		return res;
	}
	
	public static void spiralAdd(int[][] matrix, int offset, int size, List<Integer> res) {
		
		//base case
		if(size == 1) {
			res.add(matrix[offset][offset]);
			return;
		}
		
		//upper row
		for(int i = 0; i < size - 1; i++) {
			res.add(matrix[offset][i + offset]);
		}
		
		//right column
		for(int i = 0; i < size - 1; i++) {
			res.add(matrix[i + offset][matrix.length - 1 - offset]);
		}
		
		//bottom row
		for(int i = 0; i < size - 1; i++) {
			res.add(matrix[matrix.length - 1 - offset][matrix.length - 1 - offset - i]);
		}
		
		//left column
		for(int i = 0; i < size - 1; i++) {
			res.add(matrix[matrix.length - 1 - offset - i][offset]);
		}
		
		//Recursive rules
		spiralAdd(matrix, offset + 1, size - 2, res);
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, 
				          {8, 9, 4}, 
				          {7, 6, 5}};
		System.out.println(spiralMatrix(matrix));
	}
}
