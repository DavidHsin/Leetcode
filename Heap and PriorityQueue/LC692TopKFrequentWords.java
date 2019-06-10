/**
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
 */

class Solution {
    private class Freq implements Comparable<Freq>{

        public String e;
        public int freq;

        public Freq(String e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            // If two words have the same frequency, 
            // then the word with the lower alphabetical order comes first.
            if (this.freq == another.freq) {
            return another.e.compareTo(this.e);
            }
            return this.freq - another.freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        TreeMap<String, Integer> map = new TreeMap<>();
        for(String word: words){
            if(map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }

        PriorityQueue<Freq> minHeap = new PriorityQueue<>();
        for(String key: map.keySet()){
            if(minHeap.size() < k)
                minHeap.add(new Freq(key, map.get(key)));
            else if(map.get(key) > minHeap.peek().freq){
                minHeap.poll();
                minHeap.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<String> res = new LinkedList<>();
        while(!minHeap.isEmpty())
            res.add(minHeap.poll().e);
        Collections.reverse(res);
        return res;
    }
}