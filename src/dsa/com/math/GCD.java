package dsa.com.math;

import java.util.Random;

public class GCD {
	// Greatest Common Divisor for two numbers
	public static int gcdNaive(int a, int b) {
		int res = Math.min(a, b);
		while(res>0) {
			if(a%res ==0 && b%res==0) {
				break;
			}
			res--;
		}
		return res;
	}
	
	public static void main(String ...args) {
		Random random = new Random();
		int a = random.nextInt(100);
		int b = random.nextInt(200);
		System.out.println("Naive Solution of GCD for "+a+" and "+b+" is "+ gcdNaive(a, b));
		
	}
	
}
