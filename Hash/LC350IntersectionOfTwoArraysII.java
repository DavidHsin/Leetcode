/**
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
            return intersection(nums1, nums2);
        }else {
            return intersection(nums2, nums1);
        }
    }
    
    public int[] intersection(int[] small, int[] large) {
        
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        //stores elements into hashmap
        for(int i = 0; i < small.length; i++) {
            if(!counts.containsKey(small[i])) {
                counts.put(small[i], 1);
            }else {
                counts.put(small[i], counts.get(small[i]) + 1);
            }
        }
        
        //compare each element in large array with created hashmap
        for(int j = 0; j < large.length; j++) {
            if(counts.containsKey(large[j]) && counts.get(large[j]) > 0) {
                res.add(large[j]);
                counts.put(large[j], counts.get(large[j]) - 1);
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
        {
            result[i] = res.get(i);
        }
    
        return result;
    }
}