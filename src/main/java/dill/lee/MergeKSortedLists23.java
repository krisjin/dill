package dill.lee;

import dill.base.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *  
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 */
public class MergeKSortedLists23 {

    //解法1
    public static ListNode mergeKLists_1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }


    //解法
    public static ListNode mergeKLists(ListNode[] nodeArr) {
        if (nodeArr == null || nodeArr.length == 0) {
            return null;
        }
        return merge(nodeArr, 0, nodeArr.length - 1);
    }

    /**
     * 左右双指针
     *
     * @param nodeArr
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode[] nodeArr, int left, int right) {
        if (left == right) return nodeArr[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(nodeArr, left, mid);
        ListNode l2 = merge(nodeArr, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.val < node2.val) {
            node1.next = mergeTwoLists(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeTwoLists(node1, node2.next);
            return node2;
        }
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(9);

        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(node1);
        nodeList.add(node2);

        ListNode result = mergeKLists(nodeList.toArray(new ListNode[2]));

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
