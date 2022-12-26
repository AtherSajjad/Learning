package dsa.com.leetcode;

public class LongestCommonPrefix {

	// take first string chars
	// loop through other strings and compare the index chars, if no match return the common prefix
	public String longestCommonPrefix(String[] strs) {
		String output = "";
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 0; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
					return output;
				}

			}
			output += strs[0].charAt(i);

		}
		return output;
	}

	public static void main(String[] args) {
		String[] input = new String[] { "flower", "flow", "flight" };

		LongestCommonPrefix obj = new LongestCommonPrefix();
		System.out.println("Longest common prefix =" + obj.longestCommonPrefix(input));
	}
}
