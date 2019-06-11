package leetcode;

/**
 * Remove all head and tail and duplicate spaces in a given string
 * 
 * For example:
 * 
 * "_" represents one space
 * input = "____I___love_______google_so__much_____"
 * 
 * output = "I_love_google_so_much"
 * 
 * */

public class RemoveSpaces {
	
	public static String charRemoval(String input) {
		
		//return demo1(input);
		
		char[] c = input.toCharArray();
		
		int slow = 0;
		for(int fast = 0; fast < input.length(); fast++) {
			if(c[fast] == ' ' && (fast == 0 || c[fast - 1] == ' ')) {
				continue;
			}
			c[slow] = c[fast];
			slow++;
		}
		
		if(slow > 0 && c[slow - 1] == ' ') {
			return new String(c, 0, slow - 1);
		}
		
		return new String(c, 0, slow);
	}

	/**
	 * Using StringBuilder
	 */
	private static String demo1(String input) {
		StringBuilder s = new StringBuilder(input);
		
		int slow = 0;
		
		for(int fast = 0; fast < input.length(); fast++) {
			if(s.charAt(fast) == ' ' && (fast == 0 || s.charAt(fast - 1) == ' ')) {
				continue;
			}
			s.setCharAt(slow, s.charAt(fast));
			slow++;
		}
		
		if(slow > 0 && s.charAt(slow - 1) == ' ') {
			slow = slow - 1;
		}
		
		return s.substring(0, slow);
	}
	
	public static void main(String[] args) {
		String input = new String("    I   love    google so  much ");
		System.out.println(charRemoval(input));
	}
}
