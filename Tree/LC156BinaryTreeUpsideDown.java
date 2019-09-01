/**
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

Example:

Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1  
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        //base case
        if(root == null || root.left == null) {
            return root;
        }
        
        //recursive rules
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.right = root;
        root.left.left = root.right;    //no difference whether right or left is first
        root.left = null;
        root.right = null;
        return newRoot;
    }
}

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
 */