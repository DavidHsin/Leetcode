/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

class MinStack {
    
    //Using two stacks
    Stack<Integer> elementStack; //it stores all elements pushed
    Stack<Integer> minStack;     //it stores the global min

    /** initialize your data structure here. */
    public MinStack() {
        elementStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        //push elements into elementStack and in the mean time,
        //push global min into minStack
        elementStack.push(new Integer(x));
        if(minStack.isEmpty()) {    //if its empty, then we push the first element as the global min
            minStack.push(x);
        }else {                     //if it's not empty, then we compare the element with global min(minStack.peek())
            if(new Integer(x) > minStack.peek()) {
                minStack.push(minStack.peek());
            }else {
                minStack.push(x);
            }
        }
    }
    
    public void pop() {
        minStack.pop();
        elementStack.pop();
    }
    
    public int top() {
        return elementStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */