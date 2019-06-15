package leetcode;

/**
 * input = "A1B2C3D4"
 * output = "ABCD1234"
 * 
 * input = "A1B2C3D4E5"
 * output = "ABCDE12345"
 * 
 * */

public class StringShufflingI {
	public static char[] mergeSort(char[] array) {
		if (array.length == 0 || array == null) {
			return array;
		}
		int left = 0;
		int right = array.length - 1;
		mergeHelper(array, left, right);
		return array;
	}

	private static void mergeHelper(char[] array, int left, int right) {
		
		//base case
		if (left == right) {
			return;
		}
		
		//recursive rules
		int mid = (left + right) >>> 1;		//1. split array in half
		mergeHelper(array, left, mid); 		//2. sort halves
		mergeHelper(array, mid + 1, right); 
		combine(array, left, right);		//3. merge halves
	}

	private static void combine(char[] array, int left, int right) {
		int mid = (left + right) >>> 1;
		// initialize two subArrays
		char[] leftArray = new char[mid - left + 1]; 
		char[] rightArray = new char[right - mid];
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[left + i];
		}

		for (int j = 0; j < rightArray.length; j++) {
			rightArray[j] = array[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = left;
		while (i < leftArray.length && j < rightArray.length) {
			if (compareTwoChar(leftArray, rightArray, i, j) == true && leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else if (compareTwoChar(leftArray, rightArray, i, j) == true && leftArray[i] > rightArray[j]) {
				array[k] = rightArray[j];
				j++;
			} else {
				if(leftArray[i] > rightArray[j]) {
					array[k] = leftArray[i];
					i++;
				}else {
					array[k] = rightArray[j];
					j++;
				}
			}
			k++;
		}
		while (i < leftArray.length) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightArray.length) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	public static boolean compareTwoChar(char[] leftArray, char[] rightArray, int i, int j) {
		if (leftArray[i] >= 65 && rightArray[j] >= 65 || leftArray[i] <= 57 && rightArray[j] <= 57) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		char[] array = "A1B2C3D4E5".toCharArray();
		char[] sortedArray = mergeSort(array);
		for(int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}
}