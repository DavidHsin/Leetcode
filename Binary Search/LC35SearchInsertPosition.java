/**
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
       
        if(nums.length == 1) {
            return boundary(nums, target, 0, 0);
        }
        
        //when nums.length >= 2
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = (left + right) >>> 1;
            if(target >= nums[mid]) {
                left = mid;
            }else {
                right = mid;
            }
        }
        
        //there leaves only two elements
        return boundary(nums, target, left, right);
    }
    
    public int boundary(int[] nums, int target, int left, int right) {
        if(target <= nums[left]) {
            return left;
        }else if(target > nums[right]) {
            return right + 1;
        }else if(target == nums[right]) {
            return right;
        }else { //nums[left] < target < nums[right]
            return left + 1;
        }
    }
}