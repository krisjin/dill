package org.base;

import org.leetcode.ListNode;

import java.util.ArrayList;

/**
 * @author krisjin on 2019/4/21
 */
public class LinkedT {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }
}
