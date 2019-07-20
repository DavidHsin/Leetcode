/**
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
 */
//Using two stacks
class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x); //buffer all elements into s1
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!s2.isEmpty()) {   //if there are still elements in s2
            return s2.pop();
        }else {               //if there are not elements in s2, then we should check s1
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()) {
            return s2.peek();
        }else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Time complexity: 
 * push() -> O(1)
 * pop() -> O(n)
 * 
 * Space complexity: O(n)
 * 
 * And for the Amortized time complexity
 * 1st time call pop(): n(pop from s1) + n(push into s2) + 1(pop from s2) = 2 * n + 1
 * 2nd time call pop(): 1(pop from s2) = 1
 * 3rd time call pop(): 1(pop from s2) = 1
 * .
 * .
 * .
 * nth time call pop(): 1(pop from s2) = 1
 * 
 * Amortized time complexity: (2 * n + 1 + (n - 1) * 1) / n = 2 = O(1)
 */

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */