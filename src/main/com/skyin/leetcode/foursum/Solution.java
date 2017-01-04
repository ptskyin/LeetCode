package com.skyin.leetcode.foursum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by skyin on 1/4/2017.
 */
public class Solution {
	private int[] nums;
	private List<List<Integer>> list;

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		this.nums = nums;
		list = new LinkedList<>();

		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			threeSum(target - nums[i], i);
		}

		return list;
	}

	private void threeSum(int target, int pos0) {
		for (int pos1 = pos0 + 1; pos1 < nums.length - 2; pos1++) {
			if (pos1 > pos0 + 1 && nums[pos1] == nums[pos1 - 1]) {
				continue;
			}
			int nextTarget = target - nums[pos1];
			twoSum(nextTarget, pos0, pos1);
		}
	}

	private void twoSum(int target, int pos0, int pos1) {
		for (int pos2 = pos1 + 1; pos2 < nums.length - 1; pos2++) {
			if (pos2 > pos1 + 1 && nums[pos2] == nums[pos2 - 1]) {
				continue;
			}
			int nextTarget = target - nums[pos2];
			one(nextTarget, pos0, pos1, pos2);
		}
	}

	private void one(int target, int pos0, int pos1, int pos2) {
		int left = pos2 + 1;
		int right = nums.length - 1;
		if (left > right ||
				nums[left] > target ||
				nums[right] < target) {
			return;
		}
		int pos3 = left;
		while (left < right - 1) {
			pos3 = (left + right) / 2;
			if (nums[pos3] == target) {
				break;
			} else if (nums[pos3] > target) {
				right = pos3;
			} else {
				left = pos3;
			}
		}

		if (nums[left] == target) {
			pos3 = left;
		}
		if (nums[right] == target) {
			pos3 = right;
		}
		if (nums[pos3] == target) {
			List<Integer> l = new LinkedList<>();
			l.add(nums[pos0]);
			l.add(nums[pos1]);
			l.add(nums[pos2]);
			l.add(nums[pos3]);
			list.add(l);
		}
	}

}
