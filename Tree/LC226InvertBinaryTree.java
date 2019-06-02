/**
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
    public TreeNode invertTree(TreeNode root) {
        //base case
        if(root == null) {
            return null;
        }
        
        //recursive rule
        //first, reverse leaf node(for example, 1and3, 6and9)
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        //second, reverse left subtree and right subtree
        root.left = right;
        root.right = left;
        return root;
    }
}