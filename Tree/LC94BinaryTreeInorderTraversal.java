/**
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        
        //base case
        if(root == null) {
            return;
        }
        
        //recursive rules
        if(root.left != null) {
            helper(root.left, res);
        }
        
        res.add(root.val);
        
        if(root.right != null) {
            helper(root.right, res);
        }
    }
}