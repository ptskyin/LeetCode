package com.skyin.leetcode.regularexpressionmatching;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyin on 1/2/2017.
 */
public class Solution {

	public boolean isMatch(String s, String p) {
		char[] chars = s.toCharArray();
		char[] expChars = p.toCharArray();
		List<Exp> exps = new ArrayList<>();

		Exp exp = null;
		for (char c : expChars) {
			if (c == '*') {
				assert exp != null;
				exp.isStar = true;

				Exp prevExp = null;
				if (!exps.isEmpty()) {
					prevExp = exps.get(exps.size() - 1);
				}
				if (prevExp == null || !prevExp.isStar) {
					exps.add(exp);
				} else if (exp.c == '.') {
					while (exps.size() > 1 && exps.get(exps.size() - 2).isStar) {
						exps.remove(exps.size() - 1);
					}
					exps.get(exps.size() - 1).c = '.';
				} else if (prevExp.c != '.' && prevExp.c != exp.c) {
					exps.add(exp);
				}
				exp = null;
			} else {
				if (exp != null) {
					exps.add(exp);
				}
				exp = new Exp(c);
			}
		}
		if (exp != null) {
			exps.add(exp);
		}

		return isMatch(chars, 0, exps, 0);
	}

	private boolean isMatch(char[] chars, int charCount, List<Exp> exps, int expCount) {
		Exp exp, nextExp;
		while (charCount < chars.length) {
			if (expCount == exps.size()) {
				return false;
			}
			exp = exps.get(expCount);
			expCount++;

			if (!exp.isStar && exp.c != '.') {
				if (chars[charCount] != exp.c) {
					return false;
				}
				charCount++;
			}
			if (!exp.isStar && exp.c == '.') {
				charCount++;
			}
			if (exp.isStar && exp.c != '.') {
				while (charCount < chars.length && chars[charCount] == exp.c) {
					if (isMatch(chars, charCount, exps, expCount)) {
						return true;
					}
					charCount++;
				}
			}
			if (exp.isStar && exp.c == '.') {
				if (expCount == exps.size()) {
					return true;
				}
				nextExp = exps.get(expCount);
				while (charCount < chars.length) {
					while (nextExp.c != '.' && chars[charCount] != nextExp.c) {
						charCount++;
						if (charCount == chars.length) {
							return false;
						}
					}
					if (isMatch(chars, charCount, exps, expCount)) {
						return true;
					}
					charCount++;
				}
			}
		}

		while (expCount < exps.size()) {
			if (!exps.get(expCount).isStar) {
				return false;
			}
			expCount++;
		}

		return true;
	}

	private static class Exp {
		private char c;
		private boolean isStar = false;

		private Exp(char c) {
			this.c = c;
		}
	}
}
