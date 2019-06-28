package leetcode;

public class SelectionSort {
	
	public static int[] selectionSort(int[] nums) {
		for(int fixed = 0; fixed < nums.length; fixed++) {
			for(int i = fixed + 1; i < nums.length; i++) {
				if(nums[fixed] > nums[i]) {
					swap(nums, fixed, i);
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
		int[] nums = {2, 1, 4, 3, 5};
		int[] res = selectionSort(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
