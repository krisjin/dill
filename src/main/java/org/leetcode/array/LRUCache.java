package org.leetcode.array;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 最近最少使用算法，LRU算法主要用于缓存淘汰。主要目的就是把最近最少使用的数据移除内存，以增加其他数据。
 * 添加元素时，放到链表头，缓存命中，将元素移动到链表头
 * 缓存满了之后，将链表尾的元素删除
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/3
 * Time: 15:37
 */
public class LRUCache {
    /**
     * 默认负载因子大小
     */
    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    int maxCapacity;

    private Map<Object, Object> map;

    /**
     * @param maxCapacity
     */
    public LRUCache(final int maxCapacity) {
        this.maxCapacity = maxCapacity;
//        int cap = (int) Math.ceil(maxCapacity / DEFAULT_LOAD_FACTOR) + 1;
        map = Collections.synchronizedMap(new LinkedHashMap<Object, Object>(maxCapacity, DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                return size() > maxCapacity;
            }
        });
    }


    public Object get(Object key) {
        Object val = map.get(key);
        if (val == null) return -1;
        return val;
    }

    public void set(Object key, Object value) {
        map.put(key, value);
    }

    public int size() {
        return map.size();
    }
}
