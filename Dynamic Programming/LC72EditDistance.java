package leetcode;

/**
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

1. Insert a character
2. Delete a character
3. Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 * 
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        
        int[][] M = new int[length1 + 1][length2 + 1];
        
        //pre-fill the matrix
        for(int i = 0; i <= length2; i++)
            M[0][i] = i;
        for(int j = 1; j <= length1; j++)
            M[j][0] = j;
        
        //case0: M[i-1][j-1]
        //case1: 1 + M[i-1][j-1] replace
        //case2: 1 + M[i-1][j] delete
        //case3: 1 + M[i][j-1] insert
        for(int j = 1; j <= length1; j++) {
            for(int i = 1; i <= length2; i++) {
                if(word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    M[j][i] = M[j - 1][i - 1];
                }else {
                    M[j][i] = 1 + findMin(M[j - 1][i - 1], M[j][i - 1], M[j - 1][i]);
                }
            }
        }
        return M[length1][length2];
    }
    
    public int findMin(int a, int b, int c) {
        int min_num = 0;
		int temp = a < b ? a : b;
		min_num = c < temp ? c : temp;
		return min_num;
    }
}