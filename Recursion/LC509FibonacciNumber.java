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

class Solution1 {
    public int fib(int N) {
        //base case
        if(N == 0 || N == 1) {
            return N;
        }
        
        //recursive rules
        return fib(N - 1) + fib(N - 2);
    }
}

/**
 * for example, if N == 4, according to the recursive rules,
 * we painted this picture.
 *              F(4) --------------- 1
 *            /      \
 *           F(3)     F(2) --------- 2
 *          /   \     /    \
 *         F(2) F(1) F(1) F(0) ----- 4
 *        / \
 *      F(1) F(0) ------------------ 8
 * 
 * Time complexity: 1 + 2 + 4 + 8 + ... = 2 ^ 0 + 2 ^ 1 + 2 ^ 2 + ... + 2 ^ (n-1) = O(2^n)
 * Space complexity: According to Von Neumann architecture, program and data are first stored
 *                   in the memory, when computer executes the program, instructions are 
 *                   automatically and sequentially fetched from memory one by one. The concept
 *                   is called a sequential execution program.
 *                   So in this fibonacci program, instructions would follow like DFS: 
 *                   F(4) -> F(3) -> F(2) -> F(1): O(n)
 * 
 */

class Solution2 {
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