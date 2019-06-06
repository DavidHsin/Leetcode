/**
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // x is the target, k is the number of output
        
        int left = 0;
        int right = arr.length - k; //make sure there are k elements in the array
        
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (x - arr[mid] > arr[mid+k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }     
}