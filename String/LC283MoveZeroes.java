/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
 */

class Solution {
    public void moveZeroes(int[] nums) {
        
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[fast] == 0) {
                fast++;
            }else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        
        while(slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}