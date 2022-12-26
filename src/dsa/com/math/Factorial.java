package dsa.com.math;

import java.util.Random;

public class Factorial {

	public static long factorialIterative(long number) {
		long factorial = 1;
		
		for(long i = number;i>0;i--) {
			factorial = factorial * i;
		}
		
//		for (long i = 2; i <= number; i++) {
//			//System.out.println(factorial + ",:" + i);
//			factorial = factorial * i;
//		}

		return factorial;
	}

	public static long factorialRecursive(long number) {

		return number == 1 ? 1 : number * factorialRecursive(number - 1);

	}

	public static void main(String... args) {
		Random random = new Random();
		long number = random.nextLong(20);
		System.out.println("Factorial Iterative of " + number + " Is " + factorialIterative(number));
		System.out.println("Factorial Recursive of " + number + " Is " + factorialRecursive(number));
	}
}
