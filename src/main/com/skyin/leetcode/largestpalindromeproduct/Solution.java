package com.skyin.leetcode.largestpalindromeproduct;

/**
 * Created by skyin on 1/6/2017.
 */
public class Solution {
	private int max = 0;

	public int largestPalindrome(int n) {
		if (n <= 0 || n > 8) {
			throw new IllegalArgumentException();
		}
		if (n == 1) {
			return 9;
		}
		max = (int) Math.pow(10, n);
		int min = max / 10;
		int i = 0;
		while (i++ < max - 1) {
			long p = createPalindrome(n, i);
			for (int j = (int) Math.sqrt(p); j < max; j++) {
				long quotient = p / j;
//				System.out.println(c + ", " + j + ", " + (c / 1.0 / j));
				if (quotient < min) {
					break;
				}
				if (p % j == 0) {
					return (int) (p % 1337);
				}
			}
		}

		return -1;
	}

	private long createPalindrome(int n, int i) {
		long a = max - 1;
		a -= i;
		long b = reverse(a, n);
		a *= max;
		a += b;
		return a;
	}

	private long reverse(long a, int n) {
		long b = 0;
		for (int i = 0; i < n; i++) {
			b *= 10;
			b += a % 10;
			a /= 10;
		}
		return b;
	}
}
