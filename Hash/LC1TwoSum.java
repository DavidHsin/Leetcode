/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        
        //List<Integer> res = new ArrayList<>();
        //solution1: for for
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    // res.add(i);
                    // res.add(j);
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}

/**
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 * */

class Solution2 {
    public int[] twoSum(int[] nums, int target) {

        //solution2: hashtable
        
        //step1: create a hashmap
        Map<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            res.put(nums[i], i);
        }
        
        //step2: compare hashmap with difference
        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(res.containsKey(difference) && res.get(difference) != i) {
                return new int[] {i, res.get(difference)};
            }
        }
        return null;
    }
}

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */
 */