/**
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        reverseStringHelper(s, left, right);            //no return here
    }
    
    public void reverseStringHelper(char[] s, int left, int right) {
        
        //base case
        if(left >= right) {
            return;
        }
        
        //recursive rules
        swap(s, left, right);
        reverseStringHelper(s, left + 1, right - 1);    //no return here
    }
    
    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}