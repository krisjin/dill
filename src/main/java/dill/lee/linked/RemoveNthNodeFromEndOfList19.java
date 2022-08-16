package dill.lee.linked;

import dill.base.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * <pre>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * </pre>
 */
public class RemoveNthNodeFromEndOfList19 {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 0; i < length - n; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }


    public static void main(String[] args) {
        //构建单链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode newList = removeNthFromEnd(head, 2);
        while (newList != null) {
            System.out.print(newList.val + " ");
            newList = newList.next;
        }
    }


}
