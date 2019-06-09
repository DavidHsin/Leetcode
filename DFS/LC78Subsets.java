/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> subset=new ArrayList<Integer>();
        if(nums==null || nums.length==0){
            return result;
        }
        findAllSubsets(nums, 0, result, subset);
        return result;
   }
    
    private void findAllSubsets(int[] nums, int index, List<List<Integer>> result, List<Integer> subset){
         if(index==nums.length){
             result.add(new ArrayList<>(subset));
             return;
         }
         findAllSubsets(nums, index+1, result, subset);
         subset.add(nums[index]);
         findAllSubsets(nums, index+1, result, subset);
         subset.remove(subset.size()-1);
   }


}