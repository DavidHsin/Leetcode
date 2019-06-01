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
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		int left = 0;
		int right = arr.length - 1;
		while(left + 1 < right) {	//it ensures the program ends when there are two elements in this array
			//unsigned right shift
			int mid = (left + right) >>> 1;
			if(arr[mid] == target) {
				right = mid;		//it keeps at least one target in remaining array
			}else if(arr[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		if(arr[left] == target) {
			return left;
		}else if(arr[right] == target) {
			return right;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 6, 7};
		int target = 6;
		System.out.println(firstTarget(arr, target));
	}

}
