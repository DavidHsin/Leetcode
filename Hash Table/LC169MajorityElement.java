/**
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(!counts.containsKey(num)) {
                counts.put(num, 1);
            }else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        
        // for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        //     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        // }
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            //System.out.println(entry.getValue());
            if(entry.getValue() > (n / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}