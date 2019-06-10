/**
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

class Solution {
    private class Freq implements Comparable<Freq>{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            return this.freq - another.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> minHeap = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(minHeap.size() < k)
                minHeap.add(new Freq(key, map.get(key)));
            else if(map.get(key) > minHeap.peek().freq){
                minHeap.poll();
                minHeap.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!minHeap.isEmpty())
            res.add(minHeap.poll().e);
        Collections.reverse(res);
        return res;
    }
}