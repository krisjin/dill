package dill.leet;

import dill.base.TreeNodBuilder;
import dill.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User:krisjin
 * <p>
 * 二叉树的中序遍历
 * https://blog.csdn.net/jackey_jk/article/details/51033615
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * <pre>
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * </pre>
 */
public class C0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);//左
            }
            res.add(root.val); //根
            if (root.right != null) {
                helper(root.right, res);//右
            }
        }
    }


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


    public static void postOrderTraversal(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        postOrderTraversal(root.left, nums);
        postOrderTraversal(root.right, nums);
        nums.add(root.val);
//        System.out.print(root.val + "\t");
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


    //test

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        C0094 c0094 = new C0094();

//        List<Integer> nodes = c0094.inorderTraversal(treeNode);
//        List<Integer> nodes = c0094.inorderTraversalWithStack(treeNode);


        //后续递归测试
//        List nums = new ArrayList<Integer>();
//        postOrderTraversal(treeNode, nums);
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        TreeNode t = TreeNodBuilder.buildTreeNode(a);


        //后续非递归测试
        List nums = postOrderWithStack(t);
        System.out.println(nums);
    }


}
