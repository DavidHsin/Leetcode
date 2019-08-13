package leetcode;

/**
 * Dictionary Word Problem
 * 
 * Given a word and a dictionary, determine if it can be composed by
 * concatenating words from the given dictionary.
 * 
 * Assumptions
 * 
 * The given word is not null and is not empty The given dictionary is not null
 * and is not empty and all the words in the dictionary are not null or empty
 * Examples
 * 
 * Dictionary: {“bob”, “cat”, “rob”}
 * 
 * Word: “robob” return false
 * 
 * Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
 */

import java.util.HashSet;

public class DictionaryWordProblem {

	public static void main(String[] args) {
		String word = "catbobrob";
		String[] input = {"bob", "cat", "rob"};
		
		HashSet<String> dict = new HashSet<>();
		for(String s : input) {
			if(!dict.contains(s)) {
				dict.add(s);
			}
		}
		
		System.out.println(wordSolver(word, dict));
		
	}
	
	public static boolean wordSolver(String word, HashSet<String> dict) {
		
		boolean[] res = new boolean[word.length() + 1];
		for(int i = 1; i <= word.length(); i++) {
			//case0: no cut
			if(dict.contains(word.substring(0, i))) {
				res[i] = true;
				continue;
			}
			
			for(int j = 1; j < i; j++) {
				if(res[j] && dict.contains(word.substring(j, i))) {
					res[i] = true;
					break;
				}
			}
		}
//		for(int i = 0; i <= word.length(); i++) {
//			System.out.print(res[i] + " ");
//		}
//		
//		System.out.println("------");
		return res[word.length()];
		
	}
}
