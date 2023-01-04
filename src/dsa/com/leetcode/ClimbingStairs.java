package dsa.com.leetcode;

public class ClimbingStairs {

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int f0 = 1, f1 = 1;
		int i = 2;
		while (i <= n) {
			int x = f0 + f1;
			f0 = f1;
			f1 = x;
			i++;
		}
		return f1;
	}

	public static void main(String[] args) {
		int input = 2;
		System.out.println(
				"The number of steps required for " + input + " is " + new ClimbingStairs().climbStairs(input));
	}

}
