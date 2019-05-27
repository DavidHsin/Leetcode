/**
Given an array containing n numbers. 
The problem is to find the length of the longest contiguous subarray such that every element in the subarray is strictly greater than its previous element in the same subarray. 

Examples:

Input : arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2}
Output : 5
The subarray is {3, 5, 7, 8, 9}

Input : arr[] = {12, 13, 1, 5, 4, 7, 8, 10, 10, 11}
Output : 4
The subarray is {4, 7, 8, 10}
 * 
 * 
 * 
 * Solution
 * index: 0 1 2 3 4 5 6 7 8
 * array: 5 6 3 5 7 8 9 1 2
 *  len : 1 2 1 2 3 4 5 1 2   glomal_max = 5
 *  
 *  len represents the length of ascending subarray
 *  glomal_max represents the max length of all ascending subarrays
 *  
 * */
package leetcode;

public class LongestIncreasingSubarray {
	
	public static int lenOfLonIncSubarray(int[] arr) {
		int n = arr.length;
		//Base case: only one element, len[0] = 1, global_max[0] = 1
		int len = 1;
		int global_max = 1;
		//traverse from index = 1
		for(int i = 1; i < n; i++) {
			if(arr[i] <= arr[i - 1]) {	//if there are duplicate numbers, we set the len into 1
				len = 1;
			}else {
				len += 1;
				//compare len with global_max
				if(len > global_max) {
					global_max = len;
				}
			}
		}
		
		
		return global_max;
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 13, 1, 5, 4, 7, 8, 10, 10, 11};
		System.out.println(lenOfLonIncSubarray(arr));
	}
}
