/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        
        StringBuilder subList = new StringBuilder();
        combinations(n, 0, 0, subList, list);
        return list;
    }
    
    public void combinations(int n, int left, int right, StringBuilder subList, List<String> list) {
        
        //base case
        if(left == n && right == n) {
            list.add(subList.toString());               //Java syntax
            return;
        }
        
        //recursive rules
        //At first, we should add '(' into subList because the well-formed parentheses must start with '('
        //As to '(': for(int i = 1; i < n; i++)
        if(left < n) {
            subList.append("(");                        //Java syntax
            combinations(n, left + 1, right, subList, list);
            subList.deleteCharAt(subList.length() - 1); //Java syntax
        }
        
        //As to ')': for(int j = 0; j < i + 1; j++) because the largest i is (n - 1)
        if(right < left) {
            subList.append(")");
            combinations(n, left, right + 1, subList, list);
            subList.deleteCharAt(subList.length() - 1);
        }
        //And then, we consider whether adding '(' or ')'
        //Additionally, the number of ')' must less than or equals to(<=) the number of '(' during the adding process
        
    }
}