/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //it's related to operations in head node, so dummyNode is a better choice
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        
        //once one linked list is empty, while loop is over
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            //After adding node, cur = cur.next;
            cur = cur.next;
        }
        
        //case1: if the size of l1 is larger than l2 Or l2 is null
        if(l1 != null) {
            cur.next = l1;
        }
        
        //case2: if the size of l2 is larger than l1 Or l1 is null
        if(l2 != null) {
            cur.next = l2;
        }
        
        return dummyNode.next;
    }
}