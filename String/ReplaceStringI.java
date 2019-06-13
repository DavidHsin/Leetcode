package leetcode;

/**
 * Use "xx" to replace "each" in a string "teacher"
 * 
 * For example:
 * 
 * input = "teacher", target = "each", replacement = "xx"
 * output = "txxer"
 * 
 * input = "teachereac", target = "each", replacement = "xx"
 * output = "txxereac"
 * 
 * */

public class ReplaceStringI {
	
	public static String replaceString(String s, String target, String replacement) {
		//use two pointers: slow and fast
		char[] sChar = s.toCharArray();
		char[] targetChar = target.toCharArray();
		char[] replacementChar = replacement.toCharArray();
		
		int slow = 0;
		for(int fast = 0; fast < s.length(); fast++) {
			if(sChar[fast] == targetChar[0] && findTarget(sChar, targetChar, fast)) {
				replace(sChar, replacementChar, slow);
				slow += replacement.length();
				/**
				 * index: 0  1  2 3 4 5 6
				 * input: t  e  a c h e r
				 *          /\
				 *          s f
				 * after replacing, slow will move to index 3(slow = slow + length(replacement)), however, 
				 * if fast = fast + length(target), it will move to index 5, after that, it will move to index 6 because of for loop, 
				 * so it will miss the string "e" in index 5.
				 * So if we want to get the correct answer, we have to move fast to index 4, and after for loop,
				 * it move to index 5 to judge whether "e" is the start of target.
				 * */
				fast += target.length() - 1;
			}else {
				sChar[slow] = sChar[fast];
				slow++;
			}
		}
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < slow; i++) {
			res.append(sChar[i]);
		}
		return res.toString();
	}
	
	public static void replace(char[] s, char[] replacement, int start) {
		for(int i = 0; i < replacement.length; i++) {
			s[start + i] = replacement[i];
		}
	}
	
	
	public static boolean findTarget(char[] s, char[] target, int start) {
		/**
		 * index: 0 1 2 3 4 5 6 7 8
		 * char:  t e a c h e a c h
		 * if left = 5, left + 4 == length(char), continue
		 * 
		 * index: 0 1 2 3 4 5 6
		 * char:  t e a c h e r
		 * if left = 5, left + 4 > length(char), return false
		 * */
		if(start + target.length > s.length) {
			return false;
		}
		
		for(int i = 0; i < target.length; i++) {
			if(target[i] != s[start + i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "eachereac";
		String target = "each";
		String replacement = "xx";
		System.out.println(replaceString(s, target, replacement));
	}
}
