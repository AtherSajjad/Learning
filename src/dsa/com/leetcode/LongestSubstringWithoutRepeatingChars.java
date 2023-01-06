package dsa.com.leetcode;

// sliding window pattern
public class LongestSubstringWithoutRepeatingChars {

	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;

		for (int i = 0; i < s.length(); i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = i; j < s.length(); j++) {
				if (builder.indexOf(String.valueOf(s.charAt(j))) != -1) {
					break;
				}
				builder.append(s.charAt(j));
				maxLength = Math.max(maxLength, builder.length());
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String input = "pwwkew";
		System.out.println("The longest non repeating substring length "
				+ new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring(input)); // 3

	}

}
