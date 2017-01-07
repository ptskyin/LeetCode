package com.skyin.leetcode.mergeksortedlists;

import com.skyin.leetcode.ListNode;

/**
 * Created by skyin on 1/6/2017.
 */
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeKLists(lists, 0, lists.length - 1);
	}

	private ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}
		int mid = (start + end) / 2;
		return mergeTwoLists(mergeKLists(lists, start, mid),
				mergeKLists(lists, mid + 1, end));
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				cur.next = l2;
				l2 = l2.next;
			} else {
				cur.next = l1;
				l1 = l1.next;
			}
			cur = cur.next;
		}
		if (l1 == null) {
			cur.next = l2;
		} else {
			cur.next = l1;
		}

		return head.next;
	}
}
