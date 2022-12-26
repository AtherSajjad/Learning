package dsa.com.math;

import java.util.Random;

public class Palindrome {

	public static boolean isPalindrome(int number) {
		int reversed = 0;
		int original = number;
		while(number >0) {
			reversed = (reversed * 10) + (number % 10);
			number = number /10;
		}
		
		return reversed == original;
	}
	public static void main(String ...args) {
		Random random = new Random();
		int number = random.nextInt(1000);
		
		number = 78987;
		System.out.println("Is "+ number + " Palindrome: "+ isPalindrome(number));
	}
}
