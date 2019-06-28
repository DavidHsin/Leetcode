/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null||lists.length == 0) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });
        
        ListNode dummyHead = new ListNode(0);   //use dummyHead
        ListNode cur = dummyHead;
         
        for (ListNode node : lists) {           //add the first k nodes into the minHeap
            if(node != null) {
                minHeap.add(node);
            }
        }
            
        while (!minHeap.isEmpty()){
            cur.next = minHeap.poll();
            cur = cur.next;
            
            if (cur.next!=null) {
                minHeap.add(cur.next);
            }
        }
        return dummyHead.next;
    }
}