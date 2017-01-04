package com.skyin.leetcode.threesumclosest;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by skyin on 1/4/2017.
 */
public class SolutionTest {

	@Test
	public void test1() throws Exception {
		Solution solution = new Solution();
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		Assert.assertEquals(2, solution.threeSumClosest(nums, target));
	}

	@Test
	public void test2() throws Exception {
		Solution solution = new Solution();
		int[] nums = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
		int target = -52;
		Assert.assertEquals(-52, solution.threeSumClosest(nums, target));
	}

	@Test
	public void test3() throws Exception {
		Solution solution = new Solution();
		int[] nums = {0, 1, 2};
		int target = 0;
		Assert.assertEquals(3, solution.threeSumClosest(nums, target));
	}

	@Test
	public void test4() throws Exception {
		Solution solution = new Solution();
		int[] nums = {82,-16,-60,-48,32,-30,0,-89,70,-46,-82,-58,66,41,-96,-55,-49,-87,-33,-65,9,14,81,-11,80,-93,79,-63,-61,-16,22,-31,75,12,17,-6,37,-2,-89,-66,3,-95,-74,58,-95,22,11,-20,-36,60,-75,46,-52,-61,-28,7,-50,-45,93,-91,-43,35,-99,-39,53,-54,-98,-4,13,-90,23,-4,-65,29,85,-76,-64,81,32,-97,51,12,-82,-31,81,-2,-83,-9,89,-37,-23,-66,-91,-15,-98,-74,94,30,-2,-70,13,19,-77,-42,33,-70,25,77,47,-70,-70,60,-63,-4,83,13,-78,-23,28,-86,-11,-16,-57,-84,51,-48,-63,-15,29,56,-25,73,-69,23,28,90,96,41,65,-22,-43,-68,-77,31,69,-84,23,-63,-18,20,-93,-17,-48,-73,14,-95,98,-64,-12,-45,14,7,51,-61,89,-48,-23,2,-56,84,-2,27,74,-39,-18,-65,79,-36,-76,-30,44,78,-76,37,88,0,32,55,-51,23,-9,68,26,15,66,66,-56,-42,56,28,33,-32,-23,-36,-12,-76,-12,42,12,40,69,54,82,-22,-7,46,-46};
		int target = 270;
		Assert.assertEquals(270, solution.threeSumClosest(nums, target));
	}

	@Test
	public void test5() throws Exception {
		Solution solution = new Solution();
		int[] nums = {1, 1, 1, 0};
		int target = -100;
		Assert.assertEquals(2, solution.threeSumClosest(nums, target));
	}

}