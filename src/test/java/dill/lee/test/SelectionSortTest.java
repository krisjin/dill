package dill.lee.test;

import dill.base.sort.SelectionSort;
import org.junit.Test;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/8/21
 * Time: 11:06
 */
public class SelectionSortTest {

    @Test
    public void test() {
        int[] arrs = {12,9, 8, 7, 7, 6, 5, 4, 3, 2, 1, 0};
        SelectionSort.sort(arrs);
        for (int i : arrs) {
            System.out.print(i+", ");
        }
    }
}
