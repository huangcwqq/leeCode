/*
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

说明:
如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
package Tree;

import Tree.entity.TreeNode;

import java.util.Stack;


public class Symmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric2(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        System.out.println(isSymmetric2(root2));
    }

    //利用递归算法
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTemp(root.left, root.right);
    }

    public static boolean isSymmetricTemp(TreeNode p, TreeNode q) {
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        if (p != null) {
            if (isSymmetricTemp(p.left, q.right)) {
                if (!isSymmetricTemp(p.right, q.left)) {
                    return false;
                }
            } else {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
        }
        return true;
    }

    //迭代方法
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode p = stack.peek();
            stack.pop();
            TreeNode q = stack.peek();
            stack.pop();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            stack.push(p.left);
            stack.push(q.right);
            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }
}
