package dsa.com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

	// using stack
	public boolean isValid(String s) {

		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack = new Stack<>();

		// the length should be even
		if (s.length() % 2 != 0) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.keySet().contains(ch)) {
				// its an end so peek the value and test if it matches or not

				// to handle inputs like ){, here the first one will try to peek and if the stack is empty then it will throw exception
				if (stack.isEmpty()) {
					return false;
				}
				
				Character peek = stack.peek();
				if (peek == null || map.get(ch) != peek) {
					return false;
				} else {
					stack.pop();
				}
			} else {
				// its a start character so just pust to stack
				stack.push(ch);
			}
		}
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) {
		ValidParanthesis obj = new ValidParanthesis();
		String input = "){";
		System.out.println("Is " + input + " valid " + obj.isValid(input));
	}
}
