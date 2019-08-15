/**
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
             The maximum number of consecutive 1s is 3.
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        
        int[] res = new int[nums.length];
        //base case
        res[0] = nums[0];
        int globalMax = res[0];
        
        //induction rule
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == 1) {
                res[i] = res[i - 1] + nums[i];
                globalMax = Math.max(globalMax, res[i]);
            }else {
                res[i] = nums[i];
                globalMax = Math.max(globalMax, res[i]);    //case: nums = [0, 1]
            }
        }
        return globalMax;
    }
}