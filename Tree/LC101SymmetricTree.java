/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
        //starts from root
        if(root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        
        //base case
        if(left == null && right == null) {         //case 1: node is null
            return true;
        }else if(left == null || right == null) {   //case 2: one of two nodes is null
            return false;
        }else if(left.val != right.val) {           //case 3: the value of each node is different
            return false;
        }
        
        //recursive rules
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}