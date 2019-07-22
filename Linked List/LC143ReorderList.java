/**
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        ListNode startingHead = middleNode(head);
        ListNode newHead = reverseList(startingHead);
        ListNode reorderList = mergeTwoLists(head, newHead);
    }
    
    //step1: find the middle of linked list
    /**
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *           |    |
     *          mid startingHead
     * 
     * 1 -> 2 -> 3 -> 4 -> null
     *      |    |
     *     mid startingHead
     */
    public ListNode middleNode(ListNode head) {
        
        if(head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode startingHead = slow.next;
        slow.next = null;	//don't forget assigning slow->next to null to get two lists
        return startingHead;
    }
    //step2: reverse linked list starting from mid.next
    public ListNode reverseList(ListNode startingHead) {
        
        if(startingHead == null || startingHead.next == null) {
            return startingHead;
        }
        
        ListNode newHead = reverseList(startingHead.next);
        startingHead.next.next = startingHead;
        startingHead.next = null;
        
        return newHead;
    }
    //step3: merge two lists
    public ListNode mergeTwoLists(ListNode head, ListNode newHead) {
        
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        
        while(head != null && newHead != null) {
            curNode.next = head;
            head = head.next;
            curNode = curNode.next;
            
            curNode.next = newHead;
            newHead = newHead.next;
            curNode = curNode.next;    
        }
        
        if(head != null) {
            curNode.next = head;
        }
        
        if(newHead != null) {
            curNode.next = newHead;
        }
        
        return dummyHead.next;
    }
}