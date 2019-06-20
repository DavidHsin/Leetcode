package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Simulating playing card(Dou Di Zhu, a Chinese game play): shuffle and deal
 * 
 * Analysis
 * Step1: Create a collection object and store a deck of cards
 * Step2: Shuffle
 * Step3: Deal
 * Step4: Spread
 * 
 * Translation source: https://zhuanlan.zhihu.com/p/25258568
 */

public class ShufflingCards {
	
	public static void main(String[] args) {
		
		//Step1
		String[] rank = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
		String[] suit = {"hearts", "spades", "diamonds", "clubs"};
		
		HashMap<Integer, String> poker = new HashMap<>();	//store all cards with index
		ArrayList<Integer> list = new ArrayList<>();		//store every index to sort conveniently
		
		int index = 0;
		for(String s1 : rank) {
			for(String s2 : suit) {
				poker.put(index, s2.concat(s1));			//According to Chinese habits, suit is in front of rank
				list.add(index);
				index++;
			}
		}
		//System.out.println(index);						//after for loop, the value of index is 52
		
		poker.put(index, "little joker");
		list.add(index);									//add index(52) into list
		index++;
		poker.put(index, "big joker");
		list.add(index);									//add index(53) into list
		
		//Step2
		Collections.shuffle(list);
		
		//Step3: create three players
		//use TreeSet to sort index conveniently
		TreeSet<Integer> david = new TreeSet<>();
		TreeSet<Integer> jane = new TreeSet<>();
		TreeSet<Integer> william = new TreeSet<>();
		TreeSet<Integer> bottom_deal = new TreeSet<>();
		
		for(int i = 0; i < list.size(); i++) {
			if(i >= list.size() - 3) {
				bottom_deal.add(list.get(i));				//store three bottom deal
			}else if(i % 3 == 0) {
				david.add(list.get(i));
			}else if(i % 3 == 1) {
				jane.add(list.get(i));
			}else {
				william.add(list.get(i));
			}
		}
		
		//Step4: get the rank and suit by using sorted index
		spreadPoker(poker, david, "David");
		spreadPoker(poker, jane, "Jane");
		spreadPoker(poker, william, "william");
		spreadPoker(poker, bottom_deal, "Bottom Deal");
	}
	
	/**
	 * 1. return value type: void
	 * 2. parameter list: HashMap, TreeSet, String name
	 */
	public static void spreadPoker(HashMap<Integer, String> poker, TreeSet<Integer> list, String name) {
		System.out.print(name + "'s card is ");
		for(Integer i : list) {						//i is the key in HashMap
			System.out.print(poker.get(i) + " ");	//get the value
		}
		System.out.println();
	}
}
