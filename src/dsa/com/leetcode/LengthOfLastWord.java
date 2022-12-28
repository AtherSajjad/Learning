package dsa.com.leetcode;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim(); // remove spaces
		String[] split = s.split(" ");
		return split[split.length - 1].length();
	}

	public static void main(String[] args) {
		System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World")); // 5
		System.out.println(new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  ")); // 4
		System.out.println(new LengthOfLastWord().lengthOfLastWord("luffy is still joyboy")); // 6

	}
}
