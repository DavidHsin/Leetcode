package leetcode;

/**
 * Given a sorted array, return the first occurrence of the target
 * 
 * Example:
 * arr = [4, 5, 5, 5, 5, 5, 5];
 * target = 5;
 * return 1;
 * 
 * arr = [1, 2, 3, 4, 5, 6, 6, 7];
 * target = 6;
 * return 5;
 * 
 * */

public class FirstTargetInASortedArray {
	
	public static int firstTarget(int arr[], int target) {
		
		//corner case 1
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		//corner case 2
		if(arr.length == 1 && arr[0] == target) {
			return 0;
		}
		
		int left = 0;
		int right = arr.length - 1;
		while(left + 1 < right) {
			int mid = (left + right) >>> 1;
			if(arr[mid] == target) {
				right = mid;	//the different point
			}else if(arr[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		//compare the remaining two elements
		if(arr[left] == target) {
			return left;
		}else if(arr[right] == target) {
			return right;
		}else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4, 6};
		int target = 5;
		System.out.println(firstTarget(arr, target));
	}
}

/**
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
