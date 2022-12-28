package dsa.com.leetcode;

public class SearchInsertPosition {

	// write iterative binary solution, so that we can find the mid value and then
	// if found we have to return mid, else we have to
	// send mid-1, that should be within the bounds of the array

	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		boolean found = false;
		int lastMid = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			lastMid = mid;
			if (nums[mid] == target) {
				found = true;
				break;
			} else if (target < nums[mid]) {
				// search in left half
				high = mid - 1;
			} else {
				// search in right half
				low = mid + 1;
			}
		}

		if (found) {
			return lastMid;
		}

		System.out.println(low + " " + high + " " + lastMid);

		// ye tukke se laga
		return low;

	}

	public static void main(String[] args) {
		// Can be done using binary search, learn binary search and write
		int nums[] = new int[] { 1, 3, 5, 6 };
		int target = 2;
		System.out.println(new SearchInsertPosition().searchInsert(nums, target)); // 2
	}

}
