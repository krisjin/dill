package dill.leet;

import dill.base.ListNode;

/**
 * 移除链表元素
 * <pre>
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * </pre>
 *
 * @User krisjin
 * @date 2020/9/12
 */
public class RemoveElements203 {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode();
        ListNode newNode = removeElements(head, 1);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }
}
