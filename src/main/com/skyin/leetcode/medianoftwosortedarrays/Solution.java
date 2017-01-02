package com.skyin.leetcode.medianoftwosortedarrays;

import java.util.Arrays;

/**
 * Created by skyin on 12/27/2016.
 */
public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			return findMedianSorted(nums2);
		}
		if (nums2 == null || nums2.length == 0) {
			return findMedianSorted(nums1);
		}

		return findMedianSortedArrays(nums1, 0, nums1.length - 1,
				nums2, 0, nums2.length - 1);
	}

	private double findMedianSorted(int[] nums) {
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Arg arrays are null or empty");
		}

		if ((nums.length) % 2 == 0) {
			return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
		} else {
			return nums[nums.length / 2];
		}
	}

	private double findMedianSortedArrays(int[] nums1, int left1, int right1,
	                                      int[] nums2, int left2, int right2) {
		int mid1 = (left1 + right1) / 2;
		int mid2 = (left2 + right2) / 2;
		int len1 = right1 - left1 + 1;
		int len2 = right2 - left2 + 1;

		if (len1 < len2 / 2) {
			if (len2 % 2 == 0) {
				left2 = mid2 - len1 + 1;
				right2 = mid2 + len1;
			} else {
				left2 = mid2 - len1;
				right2 = mid2 + len1;
			}
			len2 = right2 - left2 + 1;
		}

		if (len2 < len1 / 2) {
			if (len1 % 2 == 0) {
				left1 = mid1 - len2 + 1;
				right1 = mid1 + len2;
			} else {
				left1 = mid1 - len2;
				right1 = mid1 + len2;
			}
			len1 = right1 - left1 + 1;
		}

		if (len1 + len2 <= 7) {
			int[] array = new int[len1 + len2];
			System.arraycopy(nums1, left1, array, 0, len1);
			System.arraycopy(nums2, left2, array, len1, len2);
			Arrays.sort(array);
			return findMedianSorted(array);
		}

		int cutLen = Math.min((len1 - 1) / 2, (len2 - 1) / 2);
		if (nums1[mid1] >= nums2[mid2]) {
			right1 -= cutLen;
			left2 += cutLen;
		} else {
			left1 += cutLen;
			right2 -= cutLen;
		}

		return findMedianSortedArrays(nums1, left1, right1,
				nums2, left2, right2);
	}
}
