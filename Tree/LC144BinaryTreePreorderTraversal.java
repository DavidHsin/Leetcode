/**
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
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
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> poList = new ArrayList<Integer>();
	    helper(root, poList);
		return poList;
	}
    
	public void helper(TreeNode root, List<Integer> poList) {
		if(root==null) {
            return;
        }
		poList.add(root.val);
		helper(root.left, poList);
		helper(root.right, poList);
	}
}