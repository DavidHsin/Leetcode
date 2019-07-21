package leetcode;

import java.util.Stack;

public class SortingIntegersUsingTwoStacks {

	public static void main(String[] args) {
		
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		stack1.push(12);
		stack1.push(34);
		stack1.push(1);
		stack1.push(5);
		stack1.push(2);
		stack1.push(3);
		
		int temp;
		while(!stack1.isEmpty()) {
			temp = stack1.pop();
			while(!stack2.isEmpty() && temp < stack2.peek()) {
				stack1.push(stack2.pop());
			}
			stack2.push(temp);
			//System.out.println("ok");
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop() + " ");
		}
	}

}
