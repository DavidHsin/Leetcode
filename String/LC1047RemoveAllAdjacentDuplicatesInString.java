/**
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */

//this question consists of just two adjacent duplicates
//if there are more than two, it doesn't work

class Solution {
    
    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0)
            return new String();
        Stack<Character> stack = new Stack();	//Using stack to solve
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == S.charAt(i))
                while(!stack.isEmpty() && stack.peek() == S.charAt(i))
                    stack.pop();
            else
                stack.push(S.charAt(i));
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}