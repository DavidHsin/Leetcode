/**
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        
        //case1: the length is different
        if(s.length() != t.length()) {
            return false;
        }
        
        //case2: the length is the same
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        Map<Character, Integer> checkAnagram = new HashMap<Character, Integer>();
        for(char c1 : sChar) {
            if(!checkAnagram.containsKey(c1)) {
                checkAnagram.put(c1, 1);
            }else {
                checkAnagram.put(c1, checkAnagram.get(c1) + 1);
            }
        }
        
        //compare each character in tChar with checkAnagram created
        for(char c2 : tChar) {
            if(checkAnagram.containsKey(c2) && checkAnagram.get(c2) > 1) {          //case1: key exists and value > 1
                checkAnagram.put(c2, checkAnagram.get(c2) - 1);
            }else if(checkAnagram.containsKey(c2) && checkAnagram.get(c2) == 1) {   //case2: key exists and value == 1
                checkAnagram.remove(c2);
            }else {
                return false;                                                       //case3: key doesn't exist
            }
            
        }
        return true;
    }
}