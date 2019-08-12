package leetcode;

public class MaximumProductCutting {
	
	public static int maxPro(int n) {
		//return method1(n);
		//return method2(n);
		
		//base case
		if(n <= 1) {
			return 0;
		}
		
		//recursive rule
		int maxProduct = 0;
		for(int i = 1; i < n; i++) {
			int best = Math.max(n - i, maxPro(n - i));
			maxProduct = Math.max(maxProduct, i * best);
		}
		return maxProduct;
	}

	/**
	 * 左大段右小段
	 */
	private static int method2(int n) {
		int[] M = new int[n + 1];
		//base case
		M[0] = 0;
		M[1] = 1;
		
		//induction rule
		for(int i = 2; i <= n; i++) {		//length of rope
			int globalMax = 0;
			for(int j = 1; j <= i / 2; j++) {	//右小段作为整体
				globalMax = Math.max(globalMax, Math.max(i - j, M[i - j]) * j);
			}
			M[i] = globalMax;
		}
		return M[n];
	}

	/**
	 * 左大段右大段
	 */
	private static int method1(int n) {
		int[] M = new int[n + 1];
		//base case, when the length of rope is 1 or 0
		M[0] = 0;
		M[1] = 1;
		
		//Induction rule
		for(int i = 2; i <= n; i++) {		//n meters, starts from 2 to n
			int globalMax = 0;
			
			for(int j = 1; j <= i / 2; j++) {//all possibilities in the left
				globalMax = Math.max(globalMax, Math.max(j, M[j]) * Math.max(i - j, M[i - j]));
			}
			M[i] = globalMax;				//Updating after each loop
		}
		return M[n];
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println(maxPro(n));
	}
}
