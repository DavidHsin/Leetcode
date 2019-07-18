/**
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2 ^ -2 = 1/2 ^ 2 = 1/4 = 0.25
 */

class Solution {
    public double myPow(double x, int n) {
        
        //recursive rules
    	/* if it writes like "return myPowHelper(x, n / 2)", it's wrong, 
    	 * because we have already divided it in myPowHelper() function and if so, 
    	 * we divide it twice, like "n / 4".
    	 */
        if(n > 0) {
            return myPowHelper(x, n);
        }else {
            return 1 / myPowHelper(x, n);
        }
        
    }
    
    public double myPowHelper(double x, int n) {
        
        if(n == 0) {
            return 1;
        }
        
        double halfValue = myPowHelper(x, n / 2);
        
        if(n % 2 == 0) {
            return halfValue * halfValue;
        }else {
            return halfValue * halfValue * x;
        }
    }
}

/**
 * For example, if n == 100, we draw the picture
 * 
 *             n -- 100
 *             |
 *             n -- 50
 *             |
 *             n -- 25
 *             |
 *             n -- 12
 *             |
 *             n -- 6
 *             |
 *             n -- 3
 *             |
 *             n -- 1(ends)
 * 
 * it has log(n) layers
 * 
 * Time complexity: O(logn), it's like binary search.
 * Space complexity: O(logn), counting the layers would be ok.
 * 
 */
 */