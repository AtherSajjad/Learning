package dsa.com.math;

import java.util.Random;

public class TrailingCountInFactorial {

	public static long countTrialingZeroInFactorial(long number) {
		long factorial = Factorial.factorialIterative(number);
		long count = 0;

		System.out.println(factorial);

		while (factorial % 10 == 0) {
			count++;
			factorial = factorial / 10;
		}

		return count;
	}
	
	public static long countTrialingZeroInFactorialOptimized(long number) {
		long count = 0;

		for(long i=5;i<=number;i=i*5) {
			count=count+(number/i);
		}


		return count;
	}

	public static void main(String[] args) {
		Random random = new Random();
		long number = random.nextLong(20);
		System.out.println("Trialing Zeros In Factorial for " + number + " Is " + countTrialingZeroInFactorial(number));
		System.out.println("Trialing Zeros In Factorial optimized for " + number + " Is " + countTrialingZeroInFactorialOptimized(number));

	}

}
