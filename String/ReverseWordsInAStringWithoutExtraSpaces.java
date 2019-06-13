package leetcode;

/**
 * Reverse words in a String without extra spaces in the head or tail
 * 
 * For example:
 * input = "I love Google"
 * output = "Google love I"
 * 
 * */

public class ReverseWordsInAStringWithoutExtraSpaces {
	
	public static String reverseWords(String input) {
        // try to convert it to char array and
        // solve the problem in-place
        char[] array = input.toCharArray();
        // 1. reverse the whole array.
        reverse(array, 0, array.length - 1);
        int start = 0;
        // 2. reverse each of the words
        for (int i = 0; i < array.length; i++) {
            // the start index of a word
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            // the end index of a word
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }

    private static void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    
    public static void main(String[] args) {
    	String s = "I love Google";
    	System.out.println(reverseWords(s));
    }
}
