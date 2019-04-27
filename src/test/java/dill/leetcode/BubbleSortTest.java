package dill.leetcode;

import dill.leetcode.sort.BubbleSort;
import org.junit.Test;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/8/20
 * Time: 14:10
 */
public class BubbleSortTest {

    @Test
    public void test() {
        int[] arrs = {23, 99, 58, 1, 9, 3, 54};
        BubbleSort.sort(arrs);
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + ",");
        }
    }
}
