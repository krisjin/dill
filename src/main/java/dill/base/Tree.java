package dill.base;

/**
 * @User krisjin
 * @date 2020/9/6
 */
public class Tree {

    private Node root;

    //前序（根，左，右），中序，后序，

    static class Node {
        public String value;
        public Node left;
        public Node right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public static void printNode(Node root) {
        if (root == null) return;
        System.err.println(root.value);

        Node left = root.left;
        Node right = root.right;

        printNode(left);
        printNode(right);


    }

    public static void main(String[] args) {
        Node left = new Node("a", new Node("al"), new Node("ar"));

        Node right = new Node("b", new Node("bl"), new Node("br"));
        Node root = new Node("root", left, right);

        printNode(root);

    }
}
