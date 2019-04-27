package dill.leetcode;

import org.junit.Test;
import dill.leetcode.array.LRUCache;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/16
 * Time: 16:46
 */
public class LRUCacheTest {

    @Test
    public void test() {

        LRUCache cache = new LRUCache(10);

        for (int i = 0; i < 10; i++) {
            cache.set(i, i + "VALUE");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object one = cache.get(0);
        Object two = cache.get(cache.size() - 1);
        System.out.println("one=" + one + "; two=" + two);

        cache.set("newkey1", "新值1");
        cache.set("newkey2", "新值2");
        cache.set("newkey3", "新值3");


    }


}
