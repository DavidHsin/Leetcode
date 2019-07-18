package leetcode;

/**
 * Given a sorted array and one target, find the most closest element to the target,
 * if the most closest one the the target itself, return itself.
 * 
 * sorted array = [0, 1, 2, 3, 4, 5, 6, 7, 10]
 * target = 8
 * return 7
 * 
 * sorted array = [0, 1, 2, 3, 4, 5]
 * target = 3
 * return 3
 * */

public class ClosestElementToTarget {
	
	public static int findClosestElement(int[] arr, int target) {
		//corner case 1
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		//corner case 2
		if(arr.length == 1) {
			return arr[0];
		}
		
		int left = 0;
		int right = arr.length - 1;
		//when there are equal to or more than 2 elements in the array
		while(left + 1 < right) {
			int mid = (left + right) >>> 1;
			if(arr[mid] <= target) {
				left = mid;
			}else {
				right = mid;
			}
		}
		
		//compare two remaining elements in the last step
		if(Math.abs(arr[left] - target) > Math.abs(arr[right] - target)) {
			return right;
		}else {
			return left;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 1, 9};
		int target = 8;
		System.out.println(findClosestElement(arr, target));
	}
}

/**
 * Time complexity: O(logn)
 * Space complexity: O(logn)
 * 
 */
