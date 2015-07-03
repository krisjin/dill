package org.leetcode.land.array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/3
 * Time: 15:37
 */
public class LRUCache {
    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
//        int cap = (int) Math.ceil(capacity / DEFAULT_LOAD_FACTOR) + 1;
        map = new LinkedHashMap<Integer, Integer>(capacity, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }


    public int get(int key) {
        Integer val = map.get(key);
        if (val == null) return -1;
        return val;
    }

    public void set(int key, int value) {
        map.put(key, value);
    }


    public static void main(String[] args) {

        LRUCache cache = new LRUCache(10);

        for (int i = 1; i < 11; i++) {
            cache.set(i, i);
        }
        cache.set(11, 11);
        System.out.println();
    }
}
