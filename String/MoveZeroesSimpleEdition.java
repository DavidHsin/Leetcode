package leetcode;

/**
 * Given an array nums, write a function move all 0's to the end of it
 * and don't maintain the relative order of the non-zero elements
 * 
 * Example:
 * 
 * input: [0, 1, 0, 3, 12]
 * output: [12, 1, 3, 0, 0] or [1, 12, 3, 0, 0] or some other outputs
 * 
 */

public class MoveZeroesSimpleEdition {
	
	public static int[] moveZeroes(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			if(nums[left] != 0) {
				left++;
			}else if(nums[right] == 0) {
				right--;
			}else {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		return nums;
	}
	
	public static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		int[] res = moveZeroes(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
