/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:
输入:
    2
   / \
  1   3
输出: true

示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释:
输入为: [5,1,4,null,null,3,6]。
根节点的值为 5 ，但是其右子节点值为 4
 */

package Tree;

import Tree.entity.TreeNode;

public class ValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
//        System.out.println(isValidBST2(root));
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(12);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(7);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.right = new TreeNode(11);
        System.out.println(isValidBST2(root2));
    }

    //慢到爆炸的递归方法,遍历左子树，所有节点必须比根节点小；同理遍历右子树，所有节点必须比根节点大；重复工作太多
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean leftVal = true;
        boolean rightVal = true;
        if (left != null) {
            leftVal = moreIterator(left, root.val);
        }
        if (right != null) {
            rightVal = lessIterator(right, root.val);
        }
        return isValidBST(left) && isValidBST(right) && leftVal && rightVal;
    }

    public static boolean moreIterator(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val >= value) {
            return false;
        }
        return moreIterator(root.left, value) && moreIterator(root.right, value);
    }

    public static boolean lessIterator(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val <= value) {
            return false;
        }
        return lessIterator(root.left, value) && lessIterator(root.right, value);
    }


    /*
    利用了“最大值”、“最小值”的思想：
    对于每个子树，都有一个最大值和一个最小值，
    对于左子树，最大值就是它的根节点的值，最小值是根节点的最小值（左父亲或者MIN_VALUE）
    对于右子树，最小值就是它的根节点的值，最大值是根节点的最大值（右父亲或者MAX_VALUE）
     */
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validBST2(root, null, null);
    }

    public static boolean validBST2(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return validBST2(root.left, min, root.val) && validBST2(root.right, root.val, max);
    }
}
