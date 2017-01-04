package com.skyin.leetcode.regularexpressionmatching;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by skyin on 1/2/2017.
 */
public class SolutionTest {
	private Solution solution = new Solution();

	@Test
	public void test1() throws Exception {
		boolean result = solution.isMatch("aa", "a");
		Assert.assertEquals(false, result);
	}

	@Test
	public void test2() throws Exception {
		boolean result = solution.isMatch("aa", "aa");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test3() throws Exception {
		boolean result = solution.isMatch("aaa", "aa");
		Assert.assertEquals(false, result);
	}

	@Test
	public void test4() throws Exception {
		boolean result = solution.isMatch("aa", "a*");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test5() throws Exception {
		boolean result = solution.isMatch("aa", ".*");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test6() throws Exception {
		boolean result = solution.isMatch("ab", ".*");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test7() throws Exception {
		boolean result = solution.isMatch("aab", "c*a*b*");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test8() throws Exception {
		boolean result = solution.isMatch("abcdabcdabcdabcd", ".*b*cd");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test9() throws Exception {
		boolean result = solution.isMatch("aaaaabbbbbbcccccddddddaaaaabbbcccccddd", ".*aaaaab*cd");
		Assert.assertEquals(false, result);
	}

	@Test
	public void test10() throws Exception {
		boolean result = solution.isMatch("aaa", "a*a");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test11() throws Exception {
		boolean result = solution.isMatch("aaabbbaaa", "a*b*a*c*d*");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test12() throws Exception {
		boolean result = solution.isMatch("aaa", "ab*a*c*a");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test13() throws Exception {
		boolean result = solution.isMatch("aaabbbaaa", ".*a");
		Assert.assertEquals(true, result);
	}

	@Test
	public void test14() throws Exception {
		boolean result = solution.isMatch("ab", ".*..");
		Assert.assertEquals(true, result);
	}

}