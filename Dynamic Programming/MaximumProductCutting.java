package leetcode;

public class MaximumProductCutting {
	
	public static int maxPro(int n) {
		
		int[] M = new int[n + 1];
		//base case, when the length of rope is 1 or 0
		M[0] = 0;
		M[1] = 0;
		
		//Induction rule
		for(int i = 2; i <= n; i++) {		//n meters, starts from 2 to n
			int global_max = 0;
			
			for(int j = 1; j < i / 2; j++) {//all possibilities in the left
				global_max = Math.max(global_max, Math.max(j, M[j]) * Math.max(i - j, M[i - j]));
			}
			M[i] = global_max;				//Updating after each loop
		}
		return M[n];
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(maxPro(n));
	}
}
