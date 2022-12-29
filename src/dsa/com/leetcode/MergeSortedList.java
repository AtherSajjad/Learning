package dsa.com.leetcode;

import java.util.ArrayList;

import dsa.com.dao.ListNode;

public class MergeSortedList {

	public static void printList(ListNode listNode) {
		do {
			System.out.print(listNode.val + " -> ");
			listNode = listNode.next;
		} while (listNode != null);
		System.out.println();
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode();
		ListNode head = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				head.next = list1;
				list1 = list1.next;
			} else {
				head.next = list2;
				list2 = list2.next;
			}

			head = head.next;
		}

		if (list1 != null) {
			head.next = list1;
		} else if (list2 != null) {
			head.next = list2;
		}

		return dummy.next;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " -> ");
		}
		System.out.println();
	}

	public static void printArrayList(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " -> ");

		}
		System.out.println();

	}

	public ArrayList<Integer> mergeTwoSortedArrays(int[] list1, int[] list2) {
		ArrayList<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while (i < list1.length && j < list2.length) {
			if (list1[i] < list2[j]) {
				result.add(list1[i]);
				i++;
			} else {
				result.add(list2[j]);
				j++;
			}
		}

		if (i < list1.length) {
			while (i < list1.length) {
				result.add(list1[i]);
				i++;
			}
		}
		if (j < list1.length) {
			while (j < list1.length) {
				result.add(list2[j]);
				j++;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		printList(new MergeSortedList().mergeTwoLists(list1, list2));

		int[] list3 = new int[] { 1, 2, 4 };
		int[] list4 = new int[] { 1, 3, 4 };

		printArrayList(new MergeSortedList().mergeTwoSortedArrays(list3, list4));

	}
}
