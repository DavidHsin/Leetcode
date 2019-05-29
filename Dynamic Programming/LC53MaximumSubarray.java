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
        int[] M = new int[nums.length];
        M[0] = nums[0];
        int global_max = nums[0];
        
        /**
         * index:   0  1   2  3   4  5  6   7  8
         * nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
         * M[i] = [-2, 1, -2, 4,  3, 5, 6,  1, 5]
         * 
         * M[i] = max(nums[i], nums[i] + M[i - 1])
         * for example, when index = 1, M[1] = max(nums[1], nums[1] + M[0]),
         * which is M[1] = max(1, -1) = 1.
         * 
         * global_max = max(global_max, M[i])
         * */
        
        //induction rules
        for(int i = 1; i < nums.length; i++) {
            M[i] = Math.max(nums[i], nums[i] + M[i - 1]);
            global_max = Math.max(global_max, M[i]);
        }
        return global_max;
    }
}