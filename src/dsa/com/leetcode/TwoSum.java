package dsa.com.leetcode;

import java.util.HashMap;

public class TwoSum {

	public void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
	}

	public int[] twoSumUsingHashMap(int[] nums, int target) {

		HashMap<Integer, Integer> differenceMap = new HashMap<>();
		for (int i = 0; i <= nums.length - 1; i++) {
			if (differenceMap.containsKey(target - nums[i])) {
				printArray(new int[] { differenceMap.get(target - nums[i]), i });

				return new int[] { differenceMap.get(target - nums[i]), i };
			} else {
				differenceMap.put(nums[i], i);
			}
		}
		return new int[] {0, 0}; // fallback
	}

	public int[] twoSum(int[] nums, int target) {
		int output[] = new int[2];
		boolean found = false;
		for (int i = 0; i <= nums.length - 1; i++) {
			for (int j = i + 1; j <= nums.length - 1; j++) {
				if (nums[i] + nums[j] == target) {
					output[0] = i;
					output[1] = j;
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		System.out.println(found);

		printArray(output);

		return output;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 4 };
		int target = 6;
		TwoSum obj = new TwoSum();
		obj.twoSumUsingHashMap(arr, target);

	}

}
