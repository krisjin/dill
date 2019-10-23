package dill.leetcode;

import dill.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User:krisjin
 * Date:2019-10-22
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
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }


    //test

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);


        C0094 c0094 = new C0094();

        List<Integer> aa = c0094.inorderTraversal(treeNode);

        System.out.println(aa);


    }


}
