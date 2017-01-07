package com.skyin.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by skyin on 1/5/2017.
 */
public class ListNode {
	public int val;
	public ListNode next = null;

	public ListNode(int x) {
		val = x;
	}

	public static ListNode constructNodes(int... x) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (int i : x) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		return head.next;
	}

	public List<Integer> toList() {
		List<Integer> list = new LinkedList<>();
		ListNode cur = this;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		return list;
	}
}
