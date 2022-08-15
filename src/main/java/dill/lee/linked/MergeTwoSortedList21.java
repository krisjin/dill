package dill.lee.linked;

import dill.base.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/
 * <pre>
 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  示例：
 *  输入：1->2->4, 1->3->4
 *  输出：1->1->2->3->4->4
 * </pre>
 */
public class MergeTwoSortedList21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //定义一个不变的preHead头结点，最终返回有序的节点，通过preHead返回
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;//获取链表next对象
            } else {
                prev.next = l2;
                l2 = l2.next;//获取链表next对象
            }
            prev = prev.next;//设置当前节点
        }

        //将l1或l2非空数据添加到 preHead的末尾
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(9);

        MergeTwoSortedList21 mergeTwoSortedList21 = new MergeTwoSortedList21();

        ListNode l = mergeTwoSortedList21.mergeTwoLists(node1, node2);

        System.out.printf(l.val + " ");
        while (l.next != null) {
            System.out.printf(l.next.val + " ");
            l = l.next;
        }
    }
}
