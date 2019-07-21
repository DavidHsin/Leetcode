/**
Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.
 

Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  				// return 2
circularDeque.isFull();					// return true
circularDeque.deleteLast();				// return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();				// return 4
 */

class MyCircularDeque {
    
    Stack<Integer> left;
    Stack<Integer> right;
    Stack<Integer> buffer;
    int currentSize;
    int maxSize;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.maxSize = k;
        this.currentSize = 0;
        
        left = new Stack<>();
        right = new Stack<>();
        buffer = new Stack<>();
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.isFull()) {
            return false;
        }
        left.push(value);
        currentSize++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.isFull()) {
            return false;
        }
        
        right.push(value);
        currentSize++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        
        if(currentSize == 0) {         //case1: deque is null
            return false;
        }
        
        if(!left.isEmpty()) {   //case2: there are remaining elements in left
            left.pop();
        }else {                 //case3: left is empty but right is not empty
            this.moveToLeft();
            left.pop();
        }
        currentSize--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        
        if(currentSize == 0) {         //case1: deque is null
            return false;
        }
        
        if(!right.isEmpty()) {  //case2: there are remaining elements in right
            right.pop();
        }else {                 //case3: right is empty but left is not empty
            this.moveToRight();
            right.pop();
        }
        currentSize--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        
        //same as deleteFront()
        if(currentSize == 0) {
            return -1;
        }
        
        if(!left.isEmpty()) {
            return left.peek();
        }else {
            this.moveToLeft();
            return left.peek();
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        
        //same as deleteLast()
        if(currentSize == 0) {
            return -1;
        }
        
        if(!right.isEmpty()) {
            return right.peek();
        }else {
            this.moveToRight();
            return right.peek();
        }
    }
    
    /**
     *  we should divide right into two parts, so there are existing one corner case,
     *  when there are only one element in right, it cannot be divided into two parts.
     */
    private void moveToLeft() {
        int rightSize = right.size();
        
        //corner case
        if(rightSize == 1) {
            left.push(right.pop());
        }
        
        //step1: move half elements from right to buffer
        while(right.size() > rightSize / 2) {
            buffer.push(right.pop());
        }
        //step2: move remaining elements from right to left
        while(!right.isEmpty()) {
            left.push(right.pop());
        }
        //step3: move all elements from buffer to right
        while(!buffer.isEmpty()) {
            right.push(buffer.pop());
        }
    }
    
    /**
     *  we should divide left into two parts, so there are existing one corner case,
     *  when there are only one element in left, it cannot be divided into two parts.
     */
    private void moveToRight() {
        int leftSize = left.size();
        
        //corner case
        if(leftSize == 1) {
            right.push(left.pop());
        }
        
        //step1: move half elements from left to buffer
        while(left.size() > leftSize / 2) {
            buffer.push(left.pop());
        }
        //step2: move remaining elements from left to right
        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        //step3: mvoe all elements from buffer to left
        while(!buffer.isEmpty()) {
            left.push(buffer.pop());
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return currentSize == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */