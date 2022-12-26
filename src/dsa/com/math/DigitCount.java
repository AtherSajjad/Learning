package dsa.com.math;

import java.util.Random;

public class DigitCount {

	public int countDigitIterative(int number) {
		int count = 0;

		while (number != 0) {
			number = number / 10;
			count++;
		}
		return count;
	}

	public int countDigitRecursive(int number) {
		if (number == 0) {
			return 0;
		}
		return 1 + countDigitRecursive(number / 10);
	}
	
	public int countDigitUsingLog(int number) {
		return (int) Math.floor(Math.log10(number)+1);
	}

	public static void main(String[] args) {

		Random random = new Random();
		int number = random.nextInt(10000);
		DigitCount digitCount = new DigitCount();
		System.out.println("Generated Number:" + number);

		System.out.println("Count Using Iterative: " + digitCount.countDigitIterative(number));
		System.out.println("Count Using Recursive: " + digitCount.countDigitRecursive(number));
		System.out.println("Count Using Log: " + digitCount.countDigitUsingLog(number));

	}

}
