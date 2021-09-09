package dill.lee;

import dill.base.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * <pre>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * </pre>
 */
public class RemoveDuplicatesFromSortedList28 {

    public static ListNode deleteDuplicates_1(ListNode head) {
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

    public static ListNode deleteDuplicates(ListNode head) {
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node1.next.next = node3;
        node1.next.next.next = node4;
        ListNode ret = deleteDuplicates(node1);

        System.out.println(ret);

    }

}
