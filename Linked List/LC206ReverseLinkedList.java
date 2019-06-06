/**
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
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
    public ListNode reverseList(ListNode head) {
        
        //base case
        if(head == null || head.next == null) {
            return head;
        }
        
        //recursive rules
        ListNode node = reverseList(head.next);
        head.next.next = head;  //Start reversing
        head.next = null;
        return node;
    }
}