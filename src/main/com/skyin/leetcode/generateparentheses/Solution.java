package com.skyin.leetcode.generateparentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by skyin on 1/6/2017.
 */
public class Solution {
	private List<String> list = new LinkedList<>();

	public List<String> generateParenthesis(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		list = new LinkedList<>();
		if (n != 0) {
			generateParenthesis("", n, n);
		}
		return list;
	}

	private void generateParenthesis(String s, int lp, int rp) {
		if (lp == 0 && rp == 0) {
			list.add(s);
			return;
		}
		if (lp != 0) {
			generateParenthesis(s + "(", lp - 1, rp);
		}
		if (lp < rp) {
			generateParenthesis(s + ")", lp, rp - 1);
		}
	}
}
