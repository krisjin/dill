package dill.leetcode;

import dill.base.ListNode;

/**
 * @author krisjin on 2019/10/18
 * 合并两个有序链表
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
 * <pre>
 *   将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *   示例：
 *
 *   输入：1->2->4, 1->3->4
 *   输出：1->1->2->3->4->4
 *
 *   </pre>
 */
public class C0021 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode preHead = new ListNode(3);

        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
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

        C0021 c0021 = new C0021();

        ListNode l = c0021.mergeTwoLists(node1, node2);

        System.out.printf(l.val + " ");
        while (l.next != null) {
            System.out.printf(l.next.val + " ");
            l = l.next;
        }
    }
}
