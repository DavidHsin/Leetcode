/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

 

Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */

class Solution {
    public int fib(int N) {
        
        int[] fiboFound = new int[N + 2];	//如果此处改成N+1会出现"java.lang.ArrayIndexOutOfBoundsException: 1"
        fiboFound[0] = 0;
        fiboFound[1] = 1;
        for(int i = 2; i <= N; i++) {
            fiboFound[i] = fiboFound[i - 1] + fiboFound[i - 2];
        }
        return fiboFound[N];
    }
}

/**
 * 
 * Dynamic programming：把表格里的value填满
 * index  0 1 2 3 4 5 6 ... 1000
 * F(n)   0 1 1 2 3 5 8 ... F(1000)
 * 
 * Time complexity: O(n)
 * 
 * */
 */