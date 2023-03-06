package dill.lee.tree;

import dill.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历 ,根左右
 * 二叉树的前序遍历：按照访问根节点——左子树——右子树的方式遍历这棵树，而在访问左子树或者右子树的时候，
 * 我们按照同样的方式遍历，直到遍历完整棵树。因此整个遍历过程天然具有递归的性质，
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    /**
     * 遍历函数
     *
     * @param root
     * @param res
     */
    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);//根节点值
        preorder(root.left, res);//遍历左子树
        preorder(root.right, res);//遍历右子树
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> treeNodes = preorderTraversal(root);
        System.out.println(treeNodes);

    }
}
