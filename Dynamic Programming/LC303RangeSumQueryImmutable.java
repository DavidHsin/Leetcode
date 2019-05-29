/**

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */

class NumArray {
    
    /**
    index1:    0   1  2   3   4   5
    nums =   [-2,  0, 3, -5,  2, -1]
    
    sum = [0, -2, -2, 1, -4, -2, -3]
    index2:0   1   2  3   4   5   6
    
    sum[i] stores the sum of the first i element, sum[0] = 0, or we can say,
    sum[i] stores the sum of nums[0...i-1]
    
    for example,
    sum[0] = 0;
    
    sum[1] = nums[0]                    = sum[0] + nums[0];
    sum[2] = nums[0] + nums[1]          = sum[1] + nums[1];
    sum[3] = nums[0] + nums[1] + nums[2]= sum[2] + nums[2];
    */
    
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */