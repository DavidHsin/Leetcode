/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * 
 * 
 * */
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        //if there is only one element in the array
        if(nums.length == 1) {
            return true;
        }
        
        int size = nums.length;
        int[] M = new int[size];
        //base case
        M[size - 1] = 1;
        
        /**
        index:  0  1  2  3  4
        input: [2, 3, 1, 1, 4]
        M[i] : 

        Base case: M[4] = True
        Induction rule: 

        */
        
        //induction rules
        for(int i =size - 2; i >= 0; i--) {
            for(int j = 0; j <= nums[i]; j++) {
                if(M[i + j] == 1 && j < size - i) {
                    M[i] = 1;
                    break;
                }
            }
        }
        return M[0] == 1;
    }
}