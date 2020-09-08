package dill.base;

/**
 * @User shijingui
 * @date 2020/9/6
 */
public class LinkedListMain {
    public Node head;
    private Node next;

    static class Node {
        public String value;
        public Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void reverse(Node head) {


    }

    public static void main(String[] args) {
        Node next = new Node("n1", new Node("n2", new Node("n3", null)));
        Node head = new Node("head", next);

        reverse(head);

    }
}
