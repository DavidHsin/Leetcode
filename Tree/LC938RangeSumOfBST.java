/**
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int sum;
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        inOrder(root, L, R);
        return sum;
    }
    
    public void inOrder(TreeNode root, int L, int R) {
        
        //base case
        if(root == null) {
            return;
        }
        
        //recursive rules
        //case1: in what condition we should discover in the left child tree
        if(root.val > L) {
            inOrder(root.left, L, R);
        }
        
        //case2: when we find what we want
        if(root.val <= R && root.val >= L) {
            sum += root.val;
        }
        
        //case3: in what condition we should discover in the right child tree
        if(root.val < R) {
            inOrder(root.right, L, R);
        }
    }
}