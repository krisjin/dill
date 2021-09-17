package dill.lee;

import dill.base.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * <pre>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * </pre>
 */
public class BinaryTreeLevelOrderTraversal102 {

    static List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public static List<Integer> levelOrder_1(TreeNode root) {

        List<Integer> numList = new ArrayList<>();

        if (root == null) {
            return numList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
            numList.add(node.val);
        }

        return numList;
    }


    public static ArrayList<Integer> levelOrder_2(TreeNode root) {

        ArrayList<Integer> lists = new ArrayList<Integer>();

        if (root == null) {
            return lists;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();

            //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if (tree.right != null) {
                stack.push(tree.right);
            }

            if (tree.left != null) {
                stack.push(tree.left);
            }

            lists.add(tree.val);
        }
        return lists;
    }


    public static void depthOrderTraversalWithRecursive() {
        depthTraversal(null);
    }

    private static void depthTraversal(TreeNode tn) {
        if (tn != null) {
            System.out.print(tn.val + "  ");
            depthTraversal(tn.left);
            depthTraversal(tn.right);
        }
    }


    public static void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public static List<List<Integer>> levelOrder_3(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        List<Integer> d = levelOrder_1(treeNode);

        List<List<Integer>> ll = levelOrder_3(treeNode);

        System.err.println(ll);
    }
}
