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
		
		//base case1
		/**
		 *     1 2 3 4
		 *     5 6 7 8
		 *     1 2 3 4
		 *     5 6 7 8
		 *  
		 *  After one spiral, the remaining matrix looks like
		 *  
		 *       6 7
		 *       2 3
		 */
		if(rowLength == 0 || columnLength == 0) {
			return;
		}
		
		//base case2
		/**
		 *      1 2 3
		 *      4 5 6
		 *      7 8 9
		 *      
		 *  After one spiral, the remaining matrix looks like
		 *  
		 *        5
		 *        
		 *  only one element in this matrix
		 */
		if(rowLength == 1 && columnLength == 1) {
			res.add(matrix[offset][offset]);
			return;
		}
		
		//base case3: one column remaining
		/**
		 *    1 2 3
		 *    4 5 6
		 *    7 8 9
		 *    3 2 1
		 *    4 5 6
		 *    
		 * After one spiral, the remaining matrix looks like
		 * 
		 *      5
		 *      8
		 *      2
		 */
		if(rowLength == 1 && columnLength >= 2) {
			for(int i = 0; i < columnLength; i++) {
				res.add(matrix[offset + i][offset]);
			}
			return;
		}
		
		//base case4: one row remaining, the same as one column remaining
		if(columnLength == 1 && rowLength >= 2) {
			for(int i = 0; i < rowLength; i++) {
				res.add(matrix[offset][offset + i]);
			}
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
		int[][] matrix = {{ 1,  2,  3}};
		System.out.println(spiralMatrix(matrix));
	}
}
