/**
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
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
    public int closestValue(TreeNode root, double target) {
        
        int res = root.val;
		while (root != null) {
			// if (Math.abs(root.val - target) < Math.abs(res - target)) {
			// 	res = root.val;
			// }
			// root = target > root.val ? root.right : root.left;
            if(Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            if(target > root.val) {
                root = root.right;
            }else {
                root = root.left;
            }
		}
		return res;
    }
}