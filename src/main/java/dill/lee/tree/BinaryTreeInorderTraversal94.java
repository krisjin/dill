package dill.lee.tree;

import dill.base.TreeNodBuilder;
import dill.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历访问 左子树——根节点——右子树 遍历这棵树
 * 二叉树的中序遍历
 * https://blog.csdn.net/jackey_jk/article/details/51033615
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * <pre>
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 * </pre>
 */
public class BinaryTreeInorderTraversal94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);//左
        res.add(root.val); //根
        inorder(root.right, res);//右
    }

    /**
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


    public static void postOrderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, res);
        postOrderTraversal(root.right, res);
        res.add(root.val);
    }

    /**
     * 二叉树后续遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> postOrderWithStack(TreeNode root) {
        List<Integer> retNodes = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode node = null;
            while (!stack.isEmpty()) {
                node = stack.peek();
                if (node.left != null && root != node.left && root != node.right) {
                    stack.push(node.left);
                } else if (node.right != null && root != node.right) {
                    stack.push(node.right);
                } else {
                    retNodes.add(stack.pop().val);
                    root = node;
                }
            }
        }
        return retNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        List<Integer> nodes = inorderTraversal(root);
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        TreeNode t = TreeNodBuilder.buildTreeNode(a);
        //后续非递归测试
        List nums = postOrderWithStack(t);
        System.out.println(nodes);
    }

}
