/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node originalCur = head;
        Node cloneCur = null;
        
        Map<Node, Node> map = new HashMap<>();
        
        //make a copy from original list to clone linked list
        while(originalCur != null) {
            cloneCur = new Node(originalCur.val);
            map.put(originalCur, cloneCur);
            originalCur = originalCur.next;
        }
        
        //adjust the original list reference again
        originalCur = head;
        
        while(originalCur != null) {
            cloneCur = map.get(originalCur);
            cloneCur.next = map.get(originalCur.next);
            cloneCur.random = map.get(originalCur.random);
            originalCur = originalCur.next;
        }
        return map.get(head);
    }
}