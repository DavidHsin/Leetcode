package leetcode;

/**
 * Remove duplicate and adjacent letters in a given string
 * 
 * For example:
 * input = "aaabb__cdd"
 * output = "ab_cd"
 * 
 * */

public class RemoveDuplicateLetters {
	
	public static String charDeduplication(String input) {
		
		if(input == null || input.length() == 0 || input.length() == 1) {
			return input;
		} 
		
		StringBuilder s = new StringBuilder(input);
		
		int slow = 1;
		for(int fast = 1; fast < input.length(); fast++) {
			if(s.charAt(fast) == s.charAt(slow - 1)) {
				continue;
			}
			s.setCharAt(slow, s.charAt(fast));
			slow++;
		}
		return s.substring(0, slow);
	}

	public static void main(String[] args) {
		String input = "abb__cdd";
		System.out.println(charDeduplication(input));
	}

}
