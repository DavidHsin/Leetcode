/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        //base case
        int last_max = nums[0];
        int global_max = nums[0];
        
        //induction rules
        for(int i = 1; i < nums.length; i++) {
            last_max = Math.max(nums[i], nums[i] + last_max);
            global_max = Math.max(global_max, last_max);
        }
        return global_max;
    }
}