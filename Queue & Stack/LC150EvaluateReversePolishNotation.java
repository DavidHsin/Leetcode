/**
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */

class Solution {
    public int evalRPN(String[] tokens) {
        
        int a = 0;
        int b = 0;
        Stack<Integer> rPN = new Stack<>();
        
        for(String token : tokens) {
            
            //if using "(token == "+")", it cannot work
            if(token.equals("+")) {
                rPN.push(rPN.pop() + rPN.pop());
            }else if(token.equals("-")) {
                //"2-1" and "1-2" are different
                b = rPN.pop();
                a = rPN.pop();
                rPN.push(a - b);
            }else if(token.equals("*")) {
                rPN.push(rPN.pop() * rPN.pop());
            }else if(token.equals("/")) {
                //"1/2" and "2/1" are different
                b = rPN.pop();
                a = rPN.pop();
                rPN.push(a / b);
            }else {
                //String to Integer in Java: parseInt
                rPN.push(Integer.parseInt(token));
            }
        }
        return rPN.pop();
    }
}