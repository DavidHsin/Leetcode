package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of M x N elements(M rows, N columns, M is not equal to N),
 * return all elements of the matrix in spiral order.
 * 
 * */

public class SpiralMatrixII {
	
	public static List<Integer> spiralMatrix(int[][] matrix) {
		List<Integer> res = new LinkedList<>();
		spiralAdd(matrix, 0, matrix[0].length, matrix.length, res);
		return res;
	}
	
	public static void spiralAdd(int[][] matrix, int offset, int rowLength, int columnLength, List<Integer> res) {
		
		//base case
		if(rowLength == 0 || columnLength == 0) {
			return;
		}
		
		//upper row
		for(int i = 0; i < rowLength - 1; i++) {
			res.add(matrix[offset][i + offset]);
		}
		
		//right column
		for(int i = 0; i < columnLength - 1; i++) {
			res.add(matrix[i + offset][matrix[0].length - 1 - offset]);
		}
		
		//bottom row
		for(int i = 0; i < rowLength - 1; i++) {
			res.add(matrix[matrix.length - 1 - offset][matrix[0].length - 1 - offset - i]);
		}
		
		//left column
		for(int i = 0; i < columnLength - 1; i++) {
			res.add(matrix[matrix.length - 1 - offset - i][offset]);
		}
		
		//Recursive rules
		spiralAdd(matrix, offset + 1, rowLength - 2, columnLength - 2, res);
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,   2,  3, 4}, 
				          {10, 11, 12, 5}, 
				          {9,   8,  7, 6}};
		System.out.println(spiralMatrix(matrix));
	}
}
