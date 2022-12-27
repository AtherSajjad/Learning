package dsa.com.leetcode;

public class ExcelSheetNumbering {

	public static void main(String[] args) {

		String number = "FXSHRXW";
		int STANDARD_CHARACTERS = 26;

		int sum = 0;
		
		number = new StringBuilder(number).reverse().toString();
		for (int i = 0; i < number.length(); i++) {
			System.out.println(number.charAt(i));
			int charPoint = number.charAt(i) - 'A' + 1;
			sum += charPoint * Math.pow(STANDARD_CHARACTERS, i);
		}

//		int sum = 0;
//		for (char c : number.toCharArray()) {
//			sum = sum * 26 + (int) c - 'A' + 1;
//		}

		System.out.println("Excel number " + number + " is equal to " + sum);
	}

}
