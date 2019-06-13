package leetcode;

/**
 * Use "good" to replace "_" in a string "good_study_good_job"
 * 
 * For example:
 * 
 * input = "good%%study%%good%%job", target = "%%", replacement = "good"
 * output = "goodgoodstudygoodgoodgoodjob"
 * 
 * 
 * */

public class ReplaceStringII {
	
	public static String replaceString(String s, String target, String replacement) {
		
		char[] sChar = s.toCharArray();
		char[] targetChar = target.toCharArray();
		char[] replacementChar = replacement.toCharArray();
		
		//1. scan the whole string to find the number of all targets
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == target.charAt(0) && s.substring(i, i + target.length()).equals(target)) {
				count += 1;
			}
		}
		//System.out.println(count);
		
		//2. calculate the new size, add extra spaces in the tail
		int extraSpaces = 0;
		int total_length = 0;
		extraSpaces = (replacement.length() - target.length()) * count;
		total_length = s.length() + extraSpaces;
		//System.out.println(total_length);
		char[] array = new char[total_length];
		for(int i = 0; i < s.length(); i++) {
			array[i] = sChar[i];
		}
		//System.out.println(array);
		
		//3. use two pointers: slow and fast starting from the tail
		int slow = total_length -1;

		for(int fast = s.length() - 1; fast >= 0; fast--) {
			if(findTarget(sChar, targetChar, fast)) {
				replace(array, replacementChar, slow);
				fast = fast - target.length() + 1;
				slow = slow - replacement.length();
			}else {
				array[slow] = sChar[fast];
				slow--;
			}
		}
		
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < array.length; i++) {
			res.append(array[i]);
			//res.reverse();
		}
		return res.toString();
	}
	
	public static void replace(char[] array, char[] replacement, int start) {
		for(int i = 0; i < replacement.length; i++) {
			array[start - i] = replacement[replacement.length - 1 - i];
		}
	}
	
	public static boolean findTarget(char[] array, char[] target, int start) {
		for(int i = 0; i < target.length; i++) {
			if(array[start - i] != target[target.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "g__d__o";
		String target = "__";
		String replacement = "200%";
		System.out.println(replaceString(s, target, replacement));
	}
}
