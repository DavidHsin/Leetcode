/**
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        HashMap<Integer, Integer> freshMap = new HashMap<>();
        
        for (int num : nums) {
           if (freshMap.containsKey(num)) {
               freshMap.put(num, freshMap.get(num) + 1);
           } else {
               freshMap.put(num, 1);
           }
        }
        
        List<Integer> res = new LinkedList<>();
        for(int key : freshMap.keySet()) {
            if(freshMap.get(key) == 2) {
                res.add(key);
            }
        }
        return res;
    }
}