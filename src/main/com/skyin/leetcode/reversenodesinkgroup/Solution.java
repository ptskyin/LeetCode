package com.skyin.leetcode.reversenodesinkgroup;

import com.skyin.leetcode.ListNode;

/**
 * Created by skyin on 1/7/2017.
 */
public class Solution {
	private ListNode[] buff;

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null) {
			return head;
		}

		buff = new ListNode[k + 1];

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = reverseSubKGroup(dummy, k);
		while (head != null) {
			head = reverseSubKGroup(head, k);
		}

		return dummy.next;
	}

	private ListNode reverseSubKGroup(ListNode head, int k) {
		buff[0] = head;
		for (int i = 0; i < k; i++) {
			buff[i + 1] = buff[i].next;
			if (buff[i + 1] == null) {
				return null;
			}
		}

		buff[0].next = buff[k];
		buff[1].next = buff[k].next;
		for (int i = 1; i < k; i++) {
			buff[i + 1].next = buff[i];
		}

		return buff[1];
	}
}
