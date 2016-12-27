package com.skyin.leetcode.helloworld;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by skyin on 12/27/2016.
 */
public class HelloWorldTest {
	@Test
	public void add1() throws Exception {
		Assert.assertEquals(5, new HelloWorld().add(2, 3));
	}

	@Test
	public void add2() throws Exception {
		Assert.assertEquals(12, new HelloWorld().add(9, 3));
	}

}