/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */

class Solution1 {	//Recursive method
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        return searchHelper(nums, left, right, target);
    }
    
    public int searchHelper(int[] nums, int left, int right, int target) {
        int mid = (left + right) >>> 1;
        
        //base case
        if(left > right) {
            return -1;
        }
        
        //recursive rules
        if(nums[mid] > target) {
            return searchHelper(nums, left, mid - 1, target);
        }else if(nums[mid] < target) {
            return searchHelper(nums, mid + 1, right, target);
        }else {
            return mid;
        }
    }
}

/**
 * Time complexity: O(logn)
 * Space complexity: O(logn)
 * 
 */

class Solution2 {	//Iterative method
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            //Mind the return value type "int"
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        /* We should use one element as the Test case,
         * if there was just one element, left = 0, right = 0,
         * it can't enter the while loop when "left < right".
        */
        while(left <= right) {
            //Magic operation, but we should add parentheses.
            int mid = left + ((right - left) >>> 1);
            if(target == nums[mid]) {
                return mid;
            }else if(target > nums[mid]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        //Mind the return value type "int"
        return -1;
    }
}

/**
 *          n
 *          |
 *          n / 2
 *          |
 *          n / 4
 *          |
 *          n / 8
 *          |
 *         ...
 *          |
 *          1
 * 
 * there are log(n) layers.
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
 */