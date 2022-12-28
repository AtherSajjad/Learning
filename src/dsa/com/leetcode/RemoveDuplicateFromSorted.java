package dsa.com.leetcode;

public class RemoveDuplicateFromSorted {

	public static void printArray(int[] array, int limit) {
		for (int i = 0; i < limit; i++) {
			System.out.print(array[i] + " -> ");
		}
		System.out.println();
	}

	// use two pointers to compare next elements
	public int removeDuplicates(int[] nums) {
		int k = nums.length;
		
		int j = 0;
		for (int i = 0; i < k - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[j++] = nums[i];
			}
		}

		nums[j++] = nums[k - 1];

		return j;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 0, 1, 1, 1, 2, 2, 2, 3, 3, 4 };

		printArray(input, input.length);

		int j = new RemoveDuplicateFromSorted().removeDuplicates(input);

		printArray(input, j);
	}

}
