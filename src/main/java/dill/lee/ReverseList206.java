package dill.lee;

import dill.base.ListNode;

/**
 * 反转链表
 * User:krisjin
 * Date:2019-10-21
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list
 * <pre>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * </pre>
 */
public class ReverseList206 {

    /**
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        //构建单链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ReverseList206 reverseList206 = new ReverseList206();
        ListNode newList = reverseList206.reverseList(head);
        while (newList != null) {
            System.out.print(newList.val + " ");
            newList = newList.next;
        }
    }

}
