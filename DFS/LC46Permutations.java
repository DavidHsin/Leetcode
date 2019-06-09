/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

/**
 *                 abc
 *           /      |         \
 *        a(bc)    b(ac)       c(ab)
 *       /    \    /   \       /  \
 *    ab(c) ac(b) ba(c) bc(a) ca(b) cb(a)
 *      |    |      |    |     |     |
 *    abc   acb    bac   bca   cab   cba
 * 
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permute(nums, 0, result);
        return result;
    }

    public void permute(int[] nums, int index, List<List<Integer>> result) {
        
        //we don't have to create: List<Integer> list = new LinkedList<>(); because we just swap the number in this array, we don't create a new space to store these subarrays. It doesn't like the LC78 Subsets
        
        //base case
        if (index == nums.length - 1) {
            List<Integer> item = new LinkedList<>();
            for (int num : nums) {
                item.add(num);
            }
            result.add(item);
            return;
        }
        
        //recursive rules
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permute(nums, index + 1, result);
            swap(nums, index , i);
        }
    }

    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}