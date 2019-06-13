package leetcode;

/**
 * Shift the whole string to the right hand side by two positions
 * 
 * For example:
 * input = "abcdefg"
 * output = "fgabcde"
 * 
 * */

public class ShiftTwoPositions {
	
	public static String shifting(String s) {
		
		char[] c = s.toCharArray();
		//first, reverse whole string into "gfedcba"
		int left = 0;
		int right = c.length - 1;
		reverse(c, left, right);
		
		//second, reverse the first two alphabets into "fg"
		//and reverse the last alphabets into "abcde" and splice two string into one "fgabcde"
		reverse(c, left, 1);
		reverse(c, 2, right);
		
		return new String(c);
	}
	
	public static void reverse(char[] c, int left, int right) {
		while(left < right) {
			char temp = c[left];
			c[left] = c[right];
			c[right] = temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		String s = "abcdefg";
		System.out.println(shifting(s));
	}
}
