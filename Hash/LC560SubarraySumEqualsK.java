/**
Given an array of integers and an integer k, 
you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //corner case
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        //using hashmap to store prefixSum
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        
        for(int num : nums) {
            prefixSum += num;
            count += sums.getOrDefault(prefixSum - k, 0);
            sums.put(prefixSum, sums.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}