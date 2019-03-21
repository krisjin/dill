package org.leetcode;

/**
 * <pre>
 * 描述：英文
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their
 * nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * 描述：中文
 * 您将得到两个表示两个非负整数的非空链表。数字以相反的顺序存储，每个节点包含一个数字。添加这两个数字，并将其作为链接列表返回。
 *
 * 您可以假定这两个数字不包含任何前导零，除了数字0本身。
 *
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * </pre>
 * User:krisibm
 * Date:2019/2/19
 */
public class AddTwoNumbers002 {

    /**
     * 思路 1 ******- 时间复杂度: O(N)******- 空间复杂度: O(1)******
     * <p>
     * 迭代，每次只算个位数的相加
     *
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

            p.next = new ListNode(tmp % 10);
            p = p.next;
            tmp = tmp / 10;
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
        AddTwoNumbers002 addTwoNumbers002 = new AddTwoNumbers002();

        ListNode listNode = addTwoNumbers002.addTwoNumbers(l1, l2);
        System.out.println(listNode.val + " " + listNode.next.val + " " + listNode.next.next.val);

    }
}
