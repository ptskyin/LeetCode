package com.skyin.leetcode.mergetwosortedlists;

import com.skyin.leetcode.ListNode;

/**
 * Created by skyin on 1/5/2017.
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
