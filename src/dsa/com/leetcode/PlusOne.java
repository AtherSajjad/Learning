package dsa.com.leetcode;

public class PlusOne {

	// taken from 
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			int digit = digits[i];
			if (digit < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}
		// it will come here only if its all 9s, otherwise it would have returned
		// previously
		int modified[] = new int[digits.length + 1];
		modified[0] = 1;
		return modified;
	}

	public static void printArray(int[] array, int limit) {
		for (int i = 0; i < limit; i++) {
			System.out.print(array[i] + " -> ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PlusOne obj = new PlusOne();

		int[] nums = new int[] { 1, 2, 9 };
		printArray(nums, nums.length);

		int[] output = obj.plusOne(nums);
		printArray(output, output.length);
	}

}
