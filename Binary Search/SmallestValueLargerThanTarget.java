package leetcode;

/**
This program finds the smallest number larger than x. 
So, in an array [10 20 30 40] and x = 25, the output should be 30.
 */

public class SmallestValueLargerThanTarget {
	
	public static int findValue(int[] arr, int target) {
		//corner case 1
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		//corner case 2
		if(arr.length == 1 && arr[0] > target) {
			return 0;
		}
		
		//ensure there are at least two elements
		int left = 0;
		int right = arr.length - 1;
		while(left + 1 < right) {
			int mid = (left + right) >>> 1;
			if(arr[mid] == target) {
				left = mid + 1;
			}else if(arr[mid] < target) {
				left = mid;
			}else {
				right = mid;
			}
		}
		
		//compare these two elements
		if(arr[left] > target) {
			return left;
		}else if(arr[right] > target) {
			return right;
		}else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] arr = {26};
		int target = 25;
		System.out.println(findValue(arr, target));
	}
}

/**
 * Time complexity: O(logn)
 * Space complexity: O(1)
 * 
 */
