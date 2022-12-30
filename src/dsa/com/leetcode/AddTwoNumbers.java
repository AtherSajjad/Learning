package dsa.com.leetcode;

import dsa.com.dao.ListNode;

public class AddTwoNumbers {

	public static void printList(ListNode listNode) {
		do {
			System.out.print(listNode.val + " -> ");
			listNode = listNode.next;
		} while (listNode != null);
		System.out.println();
	}

	// orignal submitted
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// expected output 7 0 8
		int carry = 0;
		ListNode head = new ListNode();
		ListNode result = head;
		while (l1 != null && l2 != null) {
			if (result.next == null) {
				result.next = new ListNode();
				result = result.next;
			}
			result.val = l1.val + l2.val + carry;
			carry = 0; // to reinitialize
			if (result.val > 9) {
				result.val = result.val - 10;
				carry = 1;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null) {
			while (l1 != null) {
				if (result.next == null) {
					result.next = new ListNode();
					result = result.next;
				}
				result.val = l1.val + 0 + carry;
				carry = 0;
				if (result.val > 9) {
					result.val = result.val - 10;
					carry = 1;
				}
				l1 = l1.next;
			}
		}

		if (l2 != null) {
			while (l2 != null) {
				if (result.next == null) {
					result.next = new ListNode();
					result = result.next;
				}
				result.val = l2.val + 0 + carry;
				carry = 0;
				if (result.val > 9) {
					result.val = result.val - 10;
					carry = 1;
				}
				l2 = l2.next;
			}
		}

		if (carry == 1) {
			result.next = new ListNode(1);

		}
		return head.next;

	}

	public ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
		// expected output 7 0 8
		int carry = 0;
		ListNode head = new ListNode();
		ListNode result = head;

		while (l1 != null || l2 != null || carry == 1) {
			int v1 = l1 != null ? l1.val : 0;
			int v2 = l2 != null ? l2.val : 0;

			int val = v1 + v2 + carry;
			carry = val / 10; // to reinitialize
			val = val % 10;

			result.next = new ListNode(val);

			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}

			result = result.next;
		}

		return head.next;

	}

	public static void main(String[] args) {
//		ListNode firstNumber = new ListNode(2);
//		firstNumber.next = new ListNode(4);
//		firstNumber.next.next = new ListNode(3);
//
//		ListNode secondNumber = new ListNode(5);
//		secondNumber.next = new ListNode(6);
//		secondNumber.next.next = new ListNode(4);

//		ListNode firstNumber = new ListNode(0);
//		ListNode secondNumber = new ListNode(0);

		ListNode firstNumber = new ListNode(9);
		firstNumber.next = new ListNode(9);
		firstNumber.next.next = new ListNode(9);
		firstNumber.next.next.next = new ListNode(9);
		firstNumber.next.next.next.next = new ListNode(9);
		firstNumber.next.next.next.next.next = new ListNode(9);
		firstNumber.next.next.next.next.next.next = new ListNode(9);

		ListNode secondNumber = new ListNode(9);
		secondNumber.next = new ListNode(9);
		secondNumber.next.next = new ListNode(9);
		secondNumber.next.next.next = new ListNode(9);

		printList(firstNumber);
		printList(secondNumber);

		ListNode result = new AddTwoNumbers().addTwoNumbersOptimized(firstNumber, secondNumber); // 8 -> 9 -> 9 -> 9 ->
																									// 0 -> 0 -> 0 -> 1
																									// ->

		printList(result);
	}

}
