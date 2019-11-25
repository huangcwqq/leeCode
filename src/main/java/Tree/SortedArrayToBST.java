/*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */

package Tree;

import Tree.entity.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }

    //递归
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    public static TreeNode helper(int[] nums, int low, int high) {
        if (low == high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
