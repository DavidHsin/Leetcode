package leetcode;

public class InsertionSort {
	
	public static int[] insertionSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			for(int j = i; j >= 1; j--) {
				if(nums[j] < nums[j - 1]) {
					swap(nums, j, j - 1);
				}else {
					continue;
				}
			}
		}
		return nums;
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 3, 2, 1, 8, 7, 9, 6, 5};
		int[] res = insertionSort(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
}
