package dsa.com.leetcode;

public class RemoveDuplicateFromSorted {

	public static void printArray(int[] array, int limit) {
		for (int i = 0; i < limit; i++) {
			System.out.print(array[i] + " -> ");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		int[] input = new int[] { 0,0,1,1,1,2,2,2,3,3,4 };

		int k = input.length;
		printArray(input, input.length);

		int j= 0;
		for (int i = 0; i < k - 1; i++) {
			if (input[i] != input[i + 1]) {
				input[j++]=input[i];
			}
		}
		
		input[j++]=input[k-1];
		

		printArray(input, j);
	}

}
