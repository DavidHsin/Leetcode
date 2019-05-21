/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //we can transform a 2D matrix into 1D
        //it's like [m[0][0],m[0][1],m[0][2],m[0][3],m[1][0],m[1][1],m[1][2]...m[i][j]]
        //we should know the row and column so that we can know the length
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        //use the classical binary search algorithm
        int left = 0;
        int right = row * column - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //when we get the index in the 1D matrix, we should return back to the 2D matrix to find the middle one
            int i = mid / column;
            int j = mid % column;
            if (matrix[i][j] == target) {
                return true;
            }else if (matrix[i][j] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}