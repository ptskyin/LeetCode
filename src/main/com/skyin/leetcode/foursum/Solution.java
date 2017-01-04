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
		list = new LinkedList<>();
		if (nums == null || nums.length < 4) {
			return list;
		}

		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		this.nums = nums;

		if (4 * nums[nums.length - 1] < target) {
			return list;
		}
		for (int pos0 = 0; pos0 < nums.length - 3; pos0++) {
			if (4 * nums[pos0] > target) {
				return list;
			}
			if (pos0 > 0 && nums[pos0] == nums[pos0 - 1]) {
				continue;
			}
			if (nums[pos0] + 3 * nums[nums.length - 1] < target) {
				continue;
			}
			threeSum(target - nums[pos0], pos0);
		}

		return list;
	}

	private void threeSum(int target, int pos0) {
		for (int pos1 = pos0 + 1; pos1 < nums.length - 2; pos1++) {
			if (3 * nums[pos1] > target) {
				return;
			}
			if (pos1 > pos0 + 1 && nums[pos1] == nums[pos1 - 1]) {
				continue;
			}
			if (nums[pos1] + 2 * nums[nums.length - 1] < target) {
				continue;
			}
			int nextTarget = target - nums[pos1];
			twoSum(nextTarget, pos0, pos1);
		}
	}

	private void twoSum(int target, int pos0, int pos1) {
		int pos2 = pos1 + 1;
		int pos3 = nums.length - 1;
		if (2 * nums[pos2] > target || 2 * nums[pos3] < target) {
			return;
		}
		while (pos2 < pos3) {
			int sum = nums[pos2] + nums[pos3];
			if (sum == target) {
				list.add(Arrays.asList(nums[pos0], nums[pos1], nums[pos2], nums[pos3]));
				int temp = nums[pos2];
				while (pos2 < pos3 && nums[pos2] == temp) {
					pos2++;
				}
				temp = nums[pos3];
				while (pos2 < pos3 && nums[pos3] == temp) {
					pos3--;
				}
			} else if (sum > target) {
				pos3--;
			} else {
				pos2++;
			}
		}
	}

}
