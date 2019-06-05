package leetcode;

/**
 * Given a sorted array, return the first occurrence of the target
 * 
 * Example:
 * arr = [4, 5, 5, 5, 5, 5, 5];
 * target = 5;
 * return 6;
 * 
 * arr = [1, 2, 3, 4, 5, 6, 6, 7];
 * target = 6;
 * return 6;
 * 
 * */

public class LastTargetInASortedArray {
	
	public static int lastTarget(int[] arr, int target) {
		
		//first case
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		//second case
		if(arr.length == 1) {
			if(arr[0] == target) {
				return 0;
			}else {
				return -1;
			}
		}
		
		//third case: when arr.length >= 2
		int left = 0;
		int right = arr.length - 1;
		while(left + 1 < right) {
			int mid = (left + right) >>> 1;
			if(arr[mid] == target) {
				left = mid;
			}else if(arr[mid] < target) {
				left = mid;
			}else { 
				right = mid;
			}
		}
		
		if(arr[right] == target) {
			return right;
		}else if(arr[left] == target) {
			return left;
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 5, 5, 5, 5, 5};
		int target = 5;
		System.out.println(lastTarget(arr, target));
	}
}
