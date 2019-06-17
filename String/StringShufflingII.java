package leetcode;

/**
 * input = "ABCDE12345"
 * output = "A1B2C3D4E5"
 * 
 * input = "ABCD1234"
 * output = "A1B2C3D4"
 * 
 */

public class StringShufflingII {
	
	public static String stringShuffling(String s) {
		char[] arr = s.toCharArray();
		convert(arr, 0, s.length() - 1);
		
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			res.append(arr[i]);
		}
		return res.toString();
	}
	
	public static void convert(char[] arr, int left, int right) {
		
		//base case
		if(left + 1 >= right) {
			return;
		}
		
		int size = right - left + 1;
		int mid = left + size / 2;
		int leftmid = left + size / 4;
		int rightmid = left + size * 3 / 4;
		//it cannot be "left + (3 / 4) * size", because 3/4 is 0, very important!!!
		
		reverse(arr, leftmid, mid - 1);
		reverse(arr, mid, rightmid - 1);
		reverse(arr, leftmid, rightmid - 1);
		
		convert(arr, left, left + 2 * (leftmid - left) - 1);
		convert(arr, left + 2 * (leftmid - left), right);
	}
	
	public static void reverse(char[] arr, int left, int right) {
		while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
	}

	public static void main(String[] args) {
		String s = "ABCDE12345";
		System.out.println(stringShuffling(s));
	}

}
