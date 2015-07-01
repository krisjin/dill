package org.leetcode.land.array;

/**
 * Notes:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 15:45
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates_1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (pre.val != cur.val) {
                pre.next.val = cur.val;
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node1.next.next = node3;
        node1.next.next.next = node4;
        ListNode ret = list.deleteDuplicates(node1);

        System.out.println(ret);

    }

}
