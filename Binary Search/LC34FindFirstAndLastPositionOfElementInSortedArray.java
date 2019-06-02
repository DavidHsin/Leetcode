/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1] 
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int rightPosition = 0;
        
        if(nums == null || nums.length == 0) {
            return result(-1, -1);
        }
        
        if(nums.length == 1) {
            if(nums[0] == target) {
                return result(0, 0);
            }else {
                return result(-1, -1);
            }
        }
        
        int left = 0;
        int right = nums.length - 1;
        //it ensures there are greater and equal to two elements in an array
        while(left + 1 < right) {
            int mid = (left + right) >>> 1;
            if(target == nums[mid]) {
                right = mid;
            }else if(target > nums[mid]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        
        //there are two elements in this array, nums[left, right]
        if(nums[left] == target) {
            rightPosition = findLastPosition(nums, left, target);
            return result(left, rightPosition);
        }else if(nums[right] == target) {
            rightPosition = findLastPosition(nums, left, target);
            return result(right, rightPosition);
        }
        return result(-1, -1);
    }
    
    //find the last position
    public int findLastPosition(int[] nums, int left, int target) {
        int rightPosition = left;
        //we have to traverse from nums[left + 1] to the end
        for(int i = left + 1; i < nums.length; i++) {
            if(nums[i] == target) {
                rightPosition += 1;
            }else {
                break;
            }
        }
        return rightPosition;
    }
    
    //initializing returning result
    public int[] result(int left, int right) {
        int[] res = new int[2];
        res[0] = left;
        res[1] = right;
        return res;
    }
}