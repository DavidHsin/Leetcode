/**
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 */

class Solution {
    public String toLowerCase(String str) {
        
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] <= 'Z' && c[i] >= 'A') {
                c[i] = (char)(c[i] + 32);	//Using char here
            }
        }
        return new String(c);
    }
}