/**
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return 1;
        }
        
        int slow = 0;
        int fast = 1;
        int count = 0;
        while(fast < nums.length) {
            if(nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
                fast++;
                count = 0;
            }else {
                if(count == 0) {
                    slow++;
                    nums[slow] = nums[fast];
                    fast++;
                    count++;
                }else {
                    fast++;
                }
            }
        }
        return slow + 1;
    }
}