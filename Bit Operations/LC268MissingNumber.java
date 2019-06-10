/**
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
 */

class Solution {
    public int missingNumber(int[] nums) {
        int missing_sum = 0;
        int full_sum = 0;
        for(int i = 0; i < nums.length; i++) {
            missing_sum = nums[i] ^ missing_sum;
        }
        
        for(int i = 0; i < nums.length + 1; i++) {
            full_sum = i ^ full_sum;
        }
        
        return missing_sum ^ full_sum;
    }
}