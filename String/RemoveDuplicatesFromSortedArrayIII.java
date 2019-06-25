package leetcode;

/**
Given a sorted array nums, remove all duplicates in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

input = [1,1,1,2,2,3]
output = 1, because the result array is [3] after removing all duplicates
 */

public class RemoveDuplicatesFromSortedArrayIII {
	
	public static int removeDuplicates(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		if(nums.length == 1) {
			return 1;
		}
		
		int slow1 = 0;
		int slow2 = 0;
		int fast = 1;
		while(fast < nums.length) {
			if(nums[fast] != nums[slow1]) {
				slow2++;
				nums[slow2] = nums[fast];
				fast++;
				slow1 = slow2;
			}else {
				if(slow1 == slow2) {	//the first two duplicates
					slow2--;
					fast++;
				}else {
					fast++;				//starting from the third duplicates
				}
			}
		}
		return slow2 + 1;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 2, 3, 3, 5};
		System.out.println(removeDuplicates(nums));
	}

}
