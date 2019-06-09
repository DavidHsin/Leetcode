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
        List<List<Integer>> solution = new ArrayList<>();
        if(nums == null) {
            return solution;
        }
        //Arrays.sort(nums);
        findSubsets(solution, new ArrayList<Integer>(), 0, nums);
        return solution;
    }
    
    public void findSubsets(List<List<Integer>> solution, List<Integer> subSolution, int index, int[] nums) {
        if(nums.length == index) {
            solution.add(new ArrayList<Integer>(subSolution));
            //solution.add(subSolution);
            return;
        }
        //case1: do not add
        findSubsets(solution, subSolution, index + 1, nums);    
        //case2: add nums[index] to the subSolution
        subSolution.add(nums[index]);
        findSubsets(solution, subSolution, index + 1, nums);
        subSolution.remove(subSolution.size() - 1);
        
    }
}