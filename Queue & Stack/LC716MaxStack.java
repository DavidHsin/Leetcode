/**
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
 */

class MaxStack {
    
    Stack<Integer> elementStack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        elementStack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        elementStack.push(x);   //push elements continuously
        
        if(maxStack.isEmpty()) {
            maxStack.push(x);
        }else if(new Integer(x) < maxStack.peek()) {
            maxStack.push(maxStack.peek());
        }else {
            maxStack.push(x);
        }
    }
    
    public int pop() {
        maxStack.pop();
        return elementStack.pop();
    }
    
    public int top() {
        return elementStack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        Stack<Integer> bufferStack = new Stack<>();
        
        int max = peekMax();
        //solution1: 
        // while(top() != max) {
        //     bufferStack.push(pop());
        // }
        // pop();
        
        //solution2
        while(!elementStack.isEmpty()) {
            if(max == top()) {
                pop();
                break;
            }else {
                bufferStack.push(pop());
            }
        }
        
        while(!bufferStack.isEmpty()) {
            push(bufferStack.pop());  //re-excute push() because maxStack is changed
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */