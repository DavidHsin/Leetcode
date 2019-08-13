package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StartAndEndIndexOfLargestSumOfSubarray {
	public static void main (String[] args)
	{
		//int[] nums = {-2, 1, -3, 4, 2, -8, 5, 4};
		//int[] nums = {1, 2, 4, -1, -20, 10, -1};
		int[] nums = {1, 2, 3, 4, 5};
		System.out.print(findIndex(nums));
	}
	
	public static List<Integer> findIndex(int[] nums) {
	    List<Integer> startEnd = new ArrayList<Integer>();
	    int start = 0;
	    int end = 0;
	    int solutionStart = 0;
	    int solutionEnd = 0;
	    //int globalMax = nums[0];
	    
	    int[] res = new int[nums.length];
	    res[0] = nums[0];
	    
	    int globalMax = nums[0];
	    
	    for(int i = 1; i < nums.length; i++) {
	        res[i] = Math.max(res[i - 1] + nums[i], nums[i]);
	        //globalMax = Math.max(globalMax, res[i]);
	        
	        if(res[i] >= 0 && res[i - 1] < 0) {                 //case1: res[i] > 0 and res[i - 1] < 0
	            start = i;
	            end = i;
	        }
	        
	        if(Math.max(globalMax, res[i]) > globalMax) { //reset the solutionStart and solutionEnd when globalMax is changed
	            solutionStart = start;
	            solutionEnd = end;
	            globalMax = Math.max(globalMax, res[i]);
	        }
	        
	        end = i + 1;
	    }
	    
	    startEnd.add(solutionStart);
	    startEnd.add(solutionEnd);
	    return startEnd;
	}
}

