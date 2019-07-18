package leetcode;

/**
This program finds the greatest number smaller than x. 
So, in an array [10 20 30 40] and x = 25, the output should be 20.
 */

public class LargestValueSmallerThanTarget {
	
	public static int findValue(int[] arr, int x) {
		
		//corner case 1
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		//corner case 2
		if(arr.length == 1 && arr[0] < x) {
			return 0;
		}
		
		//ensure there are at least two elements in the array
		int left = 0;
		int right = arr.length - 1;
		while(left + 1 < right) {
			int mid = (left + right) >>> 1;
			if(arr[mid] == x) {
				right = mid - 1;
			}else if(arr[mid] < x) {
				right = mid;
			}else {
				left = mid;
			}
		}
		
		if(arr[right] < x) {
			return right;
		}else if(arr[left] < x) {
			return left;
		}else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] arr = {10, 20, 25, 30};
		int x = 25;
		int res = findValue(arr, x);
		System.out.println(res);
	}
}

/**
 * Time complexity: O(logn)
 * Space complexity: O(1)
 * 
 */
