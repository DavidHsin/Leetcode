/**
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(counts.containsKey(num)) {
                return true;
            }else {
                counts.put(num, 1);
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> counts = new HashSet<Integer>(nums.length);
        for(int num : nums) {
            if(counts.contains(num)) {
                return true;
            }else {
                counts.add(num);
            }
        }
        return false;
    }
}