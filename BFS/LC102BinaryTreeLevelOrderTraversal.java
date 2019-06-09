/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        //first, we should add the root node into the queue to keep the size
        q.offer(root);
        
        while(!q.isEmpty()) {
            //at first, there are only one node in the queue, after that, it will push left node and right node into the queue
            int size = q.size();
            
            List<Integer> subList = new LinkedList<Integer>();    //it will update every time
            
            for(int i = 0; i < size; i++) {
                TreeNode cur_node = q.remove(); //remove the peek one then push left and right node into the queue
                if(cur_node.left != null) {
                    q.offer(cur_node.left);
                }
                
                if(cur_node.right != null) {
                    q.offer(cur_node.right);
                }
                
                subList.add(cur_node.val);
            }
            resultList.add(subList);
        }
        
        return resultList;
    }
}