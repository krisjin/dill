package org.other;

import org.leetcode.ListNode;

import java.util.ArrayList;

/**
 * <pre>
 *  从尾到头反过来打印出每个结点的值。
 *
 *
 * </pre>
 */
public class PrintLinkedListFromTailToHead {


    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }
}
