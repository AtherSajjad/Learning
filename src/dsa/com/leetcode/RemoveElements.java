package dsa.com.leetcode;

public class RemoveElements {

	public static void printArray(int[] array, int limit) {
		for (int i = 0; i < limit; i++) {
			System.out.print(array[i] + " -> ");
		}
		System.out.println();
	}

	// this works if there are multiple elements, but not with single elements, edge
	// cases are there like [1] and remove 1, [], 1, empty arrays
	public int removeElementFirstTry(int[] nums, int val) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] == val) {
				while (nums[j] == val) {
					j--;
				}
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}

			i++;
		}

		return j;
	}

	// changed thinking, instead of pushing to the end, push the other numbers to the front
	public int removeElement(int[] nums, int val) {
		int j = 0;
		for(int i =0;i<nums.length;i++) {
			if(nums[i]!=val) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
		
		return j;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2 };
		int remove = 3;
		printArray(arr, arr.length);
		// expected { 2, 2 } and length = 2
		int k = new RemoveElements().removeElement(arr, remove);
		System.out.println(k);
		printArray(arr, k);
	}
}
