package dill.base.linked;

import dill.base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListOps {


    public static void insert(ListNode head, ListNode newNode) {
        ListNode tmp = head.next;//待插入前驱节点
        head.next = newNode;//将前驱节点next 赋值给插入节点
        newNode.next = tmp;//待插入节点的后继节点设置
    }

    public static ListNode del(ListNode head, int value) {
        if (head.val == value) return head.next;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null && curr.val != value) {
            pre = curr;
            curr = curr.next;
        }
        if (curr != null) pre.next = curr.next;
        return head;
    }


    public static void traversal(ListNode head) {
        List<Integer> nodeList = new ArrayList<>();

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

//        insert(head, new ListNode(5));
        del(head, 3);
    }
}
