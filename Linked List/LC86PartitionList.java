/**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        
        //we should change the head node, so using dummyNode is a better choice.
        //method: divide the linked list into two parts
        //the first part are nodes less than x, the second part are nodes greater than or equal to x
        ListNode dummySmall = new ListNode(0);
        ListNode dummyLarge = new ListNode(0);
        //set the dummyHead
        ListNode cur_small = dummySmall;
        ListNode cur_large = dummyLarge;
        
        while(head != null) {
            if(head.val < x) {
                cur_small.next = head;      //cur_small is a dummynode, so we should splice head into cur_small.next
                cur_small = cur_small.next; //it's important to move cur_small
            }else {
                cur_large.next = head;
                cur_large = cur_large.next; //it's important to move cur_large
            }
            head = head.next;
        }
        
        //splice two dummyNode
        cur_large.next = null;  //we should set a null node into the tail of dummyLarge
        cur_small.next = dummyLarge.next;
        return dummySmall.next;
    }
}