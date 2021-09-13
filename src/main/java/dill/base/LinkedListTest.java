package dill.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static ArrayList<Integer> printListFromTailToHead(ListNode headNode) {
        ArrayList<Integer> ret = new ArrayList();
        if (headNode != null) {
            ret.addAll(printListFromTailToHead(headNode.next));
            ret.add(headNode.val);
        }
        return ret;
    }

    public static ListNode iter(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);


        List<Integer> ret = printListFromTailToHead(head);
        ret.forEach(i ->
                System.out.print(i + " ")
        );

        ListNode ret2 = iter(head);

        System.out.println();

        while (ret2 != null) {
            System.out.print(ret2.val + " ");
            ret2 = ret2.next;
        }

        System.out.println();
        System.out.println("--------------------------------------");
        LinkedList<String> l = new LinkedList();
//        l.addFirst("1");
        l.add("a");
        l.add("b");
        l.add("c");

        System.out.println(l.size());

        System.out.println(l.getLast());
        System.out.println(l.getFirst());
    }

}
