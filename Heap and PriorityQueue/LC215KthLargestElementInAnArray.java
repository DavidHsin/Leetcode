/**
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
 */

/**
 * for example: nums = [3, 2, 1, 5, 6, 4]
 * 
 * 1. create a minHeap
 *          2
 *         /
 *        3
 * 2. compared the remaining elements with root value, which is 2
 * (1)1 is less than 2, pass
 * (2)5 is larger than 2, remove root value 2(minHeap.poll()), add 5 and sift down
 *         5                3
 *        /   ------>      /
 *       3                5
 * (3)And so one...
 * 
 * 
 * */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //create a new minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        //add the first k elements into the minHeap, the value of root is the least one
        for(int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        
        //compare the root value with all remaining elements
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();         //remove the root value
                minHeap.add(nums[i]);   //and then add a number larger than root value
            }
        }
        
        return minHeap.peek();
    }
}