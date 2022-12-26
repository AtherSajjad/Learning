package dsa.com.leetcode;

import java.util.HashMap;

/*
 * 
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
IV			  4
IX  		  9
XL 			  40
XC 			  90
CD			  400
CM			  900
 */
public class RomanToInteger {

	static final int I = 1;
	static final int V = 5;
	static final int X = 10;
	static final int L = 50;
	static final int C = 100;
	static final int D = 500;
	static final int M = 1000;

	// special case for subtraction I
	static final int IV = 4;
	static final int IX = 9;

	// special case for subtraction X
	static final int XL = 40;
	static final int XC = 90;

	// special case for subtraction C
	static final int CD = 400;
	static final int CM = 900;

	// Simple brute force
	public int romanToInt(String s) {
		int output = 0;

		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			int incr = 1;
			if (ch == 'V') {
				output += V;
			} else if (ch == 'L') {
				output += L;
			} else if (ch == 'D') {
				output += D;
			} else if (ch == 'M') {
				output += M;
			} else if (ch == 'I') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
					output += IV;
					incr = 2;
				} else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
					output += IX;
					incr = 2;
				} else {
					output += I;
				}
			} else if (ch == 'X') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
					output += XL;
					incr = 2;
				} else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
					output += XC;
					incr = 2;
				} else {
					output += X;
				}
			} else if (ch == 'C') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
					output += CD;
					incr = 2;
				} else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
					output += CM;
					incr = 2;
				} else {
					output += C;
				}
			}
			i += incr;
		}

		return output;
	}

	// follow the numbers, if the next number is higher subtract the current value, since it will be in descending order
	// this actually uses more memory and runtime than brute force solution
	public int romanToIntUsingMapAndFollow(String s) {

		int output = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// check bounds before checking the next value
			if (i + 1 < s.length() && map.get(ch) < map.get(s.charAt(i + 1))) {
				output -= map.get(ch);
			} else {
				output += map.get(ch);
			}
		}

		return output;
	}

	public static void main(String[] args) {
		String s = "MCMXCIV";
		RomanToInteger obj = new RomanToInteger();
		System.out.println("Roman " + s + " to integer = " + obj.romanToIntUsingMapAndFollow(s));
	}
}
