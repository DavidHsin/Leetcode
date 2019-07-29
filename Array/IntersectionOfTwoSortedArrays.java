package leetcode;

public class IntersectionOfTwoSortedArrays {
	
	public static int intersectionArrays(int[] arr1, int[] arr2, int m, int n) {
		
		//corner case
		if(arr1 == null || arr1.length == 0) {
			return -1;
		}
		
		if(arr2 == null || arr2.length == 0) {
			return -1;
		}
		
		int i = 0;
		int j = 0;
		int cur = 0;
		
		while(i < m && j < n) {
			if(arr1[i] < arr2[j]) {
				i++;
			}else if(arr1[i] > arr2[j]) {
				j++;
			}else {
				arr2[cur] = arr2[j];
				cur++;
				i++;
				j++;
			}
		}
		return cur;
	}

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 4, 5, 7};
		int[] arr2 = {2, 3, 5, 6, 7};
		int m = arr1.length;
		int n = arr2.length;
		int cur = intersectionArrays(arr1, arr2, m, n);
		for(int i = 0; i < cur; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

}
