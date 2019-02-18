package org.leetcode.array;

import org.leetcode.ListNode;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/6
 * Time: 14:41
 */
public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        node1.next = node2;

        ListNode ret = reverse(node1);
        System.out.println(ret);
    }
}
