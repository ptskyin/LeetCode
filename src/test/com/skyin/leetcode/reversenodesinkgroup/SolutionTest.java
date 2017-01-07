package com.skyin.leetcode.reversenodesinkgroup;

import com.skyin.leetcode.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by skyin on 1/7/2017.
 */
public class SolutionTest {
	private Solution s = new Solution();

	@Test
	public void test1() throws Exception {
		ListNode head = ListNode.constructNodes(1, 2, 3, 4, 5);
		System.out.println(Arrays.toString(head.toList().toArray()));
		head = s.reverseKGroup(head, 2);
		System.out.println(Arrays.toString(head.toList().toArray()));
	}

}