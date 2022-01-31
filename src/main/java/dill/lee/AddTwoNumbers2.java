package dill.lee;

import dill.base.ListNode;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers
 * <pre>
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * </pre>
 */
public class AddTwoNumbers2 {

    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //创建返回的加和链表
        ListNode head = new ListNode(0);
        ListNode p = head;

        int tmp = 0;
        while (l1 != null || l2 != null || tmp != 0) {
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(tmp % 10);//余数计算
            p = p.next;
            tmp = tmp / 10;//十进位 1
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers2 addTwoNumbers002 = new AddTwoNumbers2();

        ListNode listNode = addTwoNumbers002.addTwoNumbers(l1, l2);
        System.out.println(listNode.val + " " + listNode.next.val + " " + listNode.next.next.val);
    }
}
