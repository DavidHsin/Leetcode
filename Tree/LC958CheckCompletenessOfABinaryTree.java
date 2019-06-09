/**
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
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

/**
 * 
 * For example:
 *                  1
 *               /    \
 *              2      3
 *             / \    /  \
 *            4 null  5   6
 * 
 * 
 * queue: tail -> 6 -> 5 -> null -> 4 -> 3 -> 2 -> 1 -> head
 * 
 * As long as there are still nodes in the queue which is non-null,
 * if it appears one null node or more, it is not complete.
 * 
 * If it's a complete binary tree, it looks like this
 * queue: tail -> null -> null -> 4 -> 3 -> 2 -> 1 -> head
 */

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        boolean bubble = false;
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode cur_node = queue.poll();
            if(cur_node == null) {
                bubble = true;
            }else {
                if(bubble) {
                    return false;
                }
                queue.add(cur_node.left);
                queue.add(cur_node.right);
            }
        }
        return true;
    }
}