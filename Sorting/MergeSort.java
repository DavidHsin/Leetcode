package leetcode;

public class MergeSort {
	public static int[] mergeSort(int[] array) {
		if (array.length == 0 || array == null) {
			return array;
		}
		int left = 0;
		int right = array.length - 1;
		mergeHelper(array, left, right);
		return array;
	}

	private static void mergeHelper(int[] array, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeHelper(array, left, mid); 
		mergeHelper(array, mid + 1, right); 
		combine(array, left, right);
	}

	private static void combine(int[] array, int left, int right) {
		int mid = left + (right - left) / 2;
		// initialize two subArrays
		int[] leftArray = new int[mid - left + 1]; 
		int[] rightArray = new int[right - mid];
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
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
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
	
	public static void main(String[] args) {
		int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] sortedArray = mergeSort(array);
		for(int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}
}