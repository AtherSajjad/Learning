package dsa.com.leetcode;

import java.util.HashSet;

public class HappyNumber {

	public int eachNumberSquared(int n) {
		int sum = 0;
		while (n > 0) {
			sum += Math.pow(n % 10, 2);
			n = n / 10;
		}

		return sum;
	}

	// Not given in leet code, but endlessly in a loop means, it will continue to
	// generate a finite number which will not be 1.
	// The number will repeat after every x number of steps, the info was taken from
	// geekforgeeks on when the number can be declared to be in a loop.
	public boolean isHappy(int n) {
		boolean result = false;
		HashSet<Integer> visited = new HashSet<>();
		while (true) {
			int sum = eachNumberSquared(n);
			if (visited.contains(sum)) {
				result = false;
				break;
			}
			if (sum == 1) {
				result = true;
				break;
			} else {
				visited.add(sum);
			}
			n = sum;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println("19 is happy number " + new HappyNumber().isHappy(19));
		System.out.println("2 is happy number " + new HappyNumber().isHappy(2));

	}
}
