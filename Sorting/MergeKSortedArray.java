package leetcode;

import java.util.*;

public class MergeKSortedArray {
	public static int[] merge(int[][] arrayOfArrays) {
		PriorityQueue<Element> minHeap = new PriorityQueue<Element>(new CompareTo());
		
		int totalLength = 0;
		for (int i = 0; i < arrayOfArrays.length; i++) {
			int[] array = arrayOfArrays[i];
			totalLength += array.length;	//get the whole length of k sorted arrays
			if (array.length != 0) {
				//store the first k elements into minHeap(a[0][0], a[1][0], ..., a[k][0])
				minHeap.offer(new Element(i, 0, array[0]));
			}
		}

		int[] result = new int[totalLength];
		int resultIndex = 0;
		
		while (!minHeap.isEmpty()) {
			Element temp = minHeap.poll();	//Element of the first temp is (0, 0, value)
			result[resultIndex] = temp.value;
			resultIndex++;

			if (temp.y + 1 < arrayOfArrays[temp.x].length) {
				temp.y++;
				temp.value = arrayOfArrays[temp.x][temp.y];
				minHeap.offer(temp);
			}
		}
		return result;
	}
	
	static class Element {
		//it's like M[x][j] in a 2D Matrix
		int x;	//which array in these arrays(index of array)
		int y;	//which number in one array(index in this array)
		int value;

		Element(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	static class CompareTo implements Comparator<Element> {
		public int compare(Element e1, Element e2) {
			if (e1.value == e2.value) {
				return 0;
			}

			return e1.value < e2.value ? -1 : 1;
		}
	}
	
	public static void main(String[] args) {
		int[][] array = {{1, 3, 5}, {2, 4, 6}, {6, 8}};
		int[] res = merge(array);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
