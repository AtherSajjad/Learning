package dsa.com.leetcode;

public class ReverseNumber {
	public int reverse(int x) {
		int reverse = 0;

		while (x != 0) {
			try {
				reverse = Math.multiplyExact(reverse, 10);
				reverse = Math.addExact(reverse, x % 10);
			} catch (Exception e) {
				return 0;
			}
			x = x / 10;
		}

		return reverse;
	}

	// 9646324351
	// 2147483646
	public static void main(String[] args) {
		int x = 1534236469;
		System.out.println(x + " -> " + new ReverseNumber().reverse(x));
	}
}
