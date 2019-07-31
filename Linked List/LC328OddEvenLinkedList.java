/**
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode curOdd = dummyOdd;
        ListNode curEven = dummyEven;
        
        while(head != null) {
            curOdd.next = head;
            curOdd = curOdd.next;
            head = head.next;
            
            if(head == null) {
                curEven.next = null;
                // break;
            }else {
                curEven.next = head;
                curEven = curEven.next;
                head = head.next;
            }
        }
        curOdd.next = dummyEven.next;
        return dummyOdd.next;
    }
}