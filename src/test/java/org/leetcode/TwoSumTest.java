package org.leetcode;

import org.junit.Test;
import org.leetcode.array.TwoSum;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/16
 * Time: 21:55
 */
public class TwoSumTest {

    @Test
    public void test() {

        int[] nums = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, 9);

        System.out.println("index1=" + result[0] + ", index2=" + result[1]);
    }
}
