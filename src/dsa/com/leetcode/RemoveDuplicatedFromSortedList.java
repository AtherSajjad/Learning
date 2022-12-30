package dsa.com.leetcode;

import dsa.com.dao.ListNode;

public class RemoveDuplicatedFromSortedList {

	public static void printList(ListNode listNode) {
		do {
			System.out.print(listNode.val + " -> ");
			listNode = listNode.next;
		} while (listNode != null);
		System.out.println();
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode curNode = head;
		ListNode dummy = new ListNode();
		ListNode result = dummy;
		while (curNode != null) {
			if (curNode.next != null && curNode.val != curNode.next.val) {
				dummy.next = new ListNode(curNode.val);
				dummy = dummy.next;
			}

			if (curNode.next == null) {
				dummy.next = new ListNode(curNode.val);
			}

			curNode = curNode.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(2);

		// 1 1 2 3 3
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(3);
//		head.next.next.next.next = new ListNode(3);

		ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));

		printList(head);

		printList(new RemoveDuplicatedFromSortedList().deleteDuplicates(head));
	}
}
