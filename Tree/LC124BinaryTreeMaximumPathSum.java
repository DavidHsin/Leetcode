/**
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
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
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxHelper(root);
        return max;        
    }
    
    public int maxHelper(TreeNode node) {
        //base case
        if(node == null) {
            return 0;
        }
        
        //step1: expect from left and right
        int left = maxHelper(node.left);
        int right = maxHelper(node.right);
        
        //step2: operations in this layer
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max = max < (left + right + node.val) ? (left + right + node.val) : max;
        
        //step3: return the value to parent
        return left < right ? (right + node.val) : (left + node.val);
    }
}