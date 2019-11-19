/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7

返回它的最大深度 3
 */

package Tree;

import Tree.entity.TreeNode;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    //利用递归运算
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null || right != null) {
            int l = maxDepth(left);
            int r = maxDepth(right);
            return (l > r ? l : r) + 1;
        }
        return 1;
    }
}
