/**
Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the Kth smallest element in the matrix.

Note that it is the Kth smallest element in the sorted order, 
not the Kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
 */

class Solution {
    
    private class Cell {
		int row, col, val;

		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
    
    public int kthSmallest(int[][] matrix, int k) {
        
        int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];

		PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (c1.val == c2.val) {
					return 0;
				}
				return c1.val < c2.val ? -1 : 1;
			}
		});

		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;

		for (int i = 0; i < k - 1; i++) {
            
            //expand one, generate two
			Cell cur = minHeap.poll();
			if (cur.row + 1 < row && !visited[cur.row + 1][cur.col]) {
				minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				visited[cur.row + 1][cur.col] = true;
			}
			if (cur.col + 1 < col && !visited[cur.row][cur.col + 1]) {
				minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				visited[cur.row][cur.col + 1] = true;
			}
            //because of minHeap, it can sort automatically
		}

		return minHeap.peek().val;
    }
}

/**
Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Steps:
      i=0   i=1  i=2 ...... i=6(i < k - 1)
1 ->   5     9    10         13
      /     / \   / \        /
     10    10 11 11 13      15
return minHeap.peek().val --> 13
 */