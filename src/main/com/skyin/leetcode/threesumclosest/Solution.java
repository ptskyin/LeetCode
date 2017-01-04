package com.skyin.leetcode.threesumclosest;

import java.util.Arrays;

/**
 * Created by skyin on 1/4/2017.
 */
public class Solution {
	private int[] nums;
	private int[] pos;
	private int diff;

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		this.nums = nums;
		pos = new int[]{0, 1, 2};
		diff = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			twoSumClosest(target - nums[i], i);
			if (diff == 0) return target;
		}

		return nums[pos[0]] + nums[pos[1]] + nums[pos[2]];
	}

	private void twoSumClosest(int target, int pos0) {
		for (int pos1 = pos0 + 1; pos1 < nums.length - 1; pos1++) {
			if (pos1 > pos0 + 1 && nums[pos1] == nums[pos1 - 1]) {
				continue;
			}
			int nextTarget = target - nums[pos1];
			if (nextTarget < nums[pos1]) {
				return;
			}
			closest(nextTarget, pos0, pos1);
			if (diff == 0) {
				return;
			}
		}
	}

	private void closest(int target, int pos0, int pos1) {
		int left = pos1 + 1;
		int right = nums.length - 1;
		if (left > right) {
			return;
		}
		int mid;
		while (left < right - 1) {
			mid = (left + right) / 2;
			if (nums[mid] == target) {
				left = mid;
				right = mid;
				break;
			} else if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}

		int pos2;
		if ((nums[left] + nums[right]) / 2 > target) {
			pos2 = left;
		} else {
			pos2 = right;
		}

		int diff = Math.abs(target - nums[pos2]);
		if (diff < this.diff) {
			this.diff = diff;
			pos[0] = pos0;
			pos[1] = pos1;
			pos[2] = pos2;
		}
	}

}
