package dsa.com.leetcode;

public class AddBinaryString {

	public String addBinary(String a, String b) {

		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		String result = "";
		while (i >= 0 || j >= 0) {
			int x = i >= 0 ? Integer.parseInt(a.charAt(i) + "") : 0;
			int y = j >= 0 ? Integer.parseInt(b.charAt(j) + "") : 0;

			int value = x + y + carry;
			carry = value / 2;
			value = value % 2;

			result = value + result;

			if (i >= 0)
				i--;
			if (j >= 0)
				j--;

		}

		if (carry == 1) {
			result = "1" + result;
		}

		return result;
	}

	public static void main(String[] args) {
		String input1 = "1010";
		String input2 = "1011";
		System.out.println(input1 + "+" + input2 + "=" + new AddBinaryString().addBinary(input1, input2));
		// expected 100
	}

}
