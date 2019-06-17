/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> distinct = new HashSet<>(); //store unique characters
        
        int slow = 0;
        int fast = 0;
        int longest = 0;
        
        while(fast < s.length()) {
            if(distinct.contains(s.charAt(fast))) {
                distinct.remove(s.charAt(slow));
                slow++;
            }else {
                distinct.add(s.charAt(fast));
                fast++;
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }
}