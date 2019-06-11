package leetcode;

/**
 * Remove a/some particular chars from a string in place
 * 
 * Example:
 * String input = "student", remove "u" and "n"
 * output = "stdet"
 * 
 * */

public class RemoveParticularCharsFromAString {
	
	public static String charRemoval(String input) {
		//it's crucial to use "StringBuilder" to solve this problem, that's easier.
		StringBuilder s = new StringBuilder(input);
		int i = 0;
		for(int j = 0; j < input.length(); j++) {
			if(s.charAt(j) != 'u' && s.charAt(j) != 'n') {
				s.setCharAt(i, s.charAt(j));
				i++;
			}
		}
		return s.substring(0, i);
		//pay attention to the usage of "setCharAt", "charAt", "substring"
	}
	
	
	public static void main(String[] args) {
		String input = "studennt";
		System.out.println(charRemoval(input));
	}
}
