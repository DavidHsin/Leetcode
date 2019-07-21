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
        ListNode nextListNode = reverseList(head.next);
        
        head.next.next = head;  //these two steps cannot reverse
        head.next = null;
        
        return nextListNode;
    }
}