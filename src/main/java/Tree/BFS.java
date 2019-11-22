/*
广度优先遍历：从根节点出发，在横向遍历二叉树层段节点的基础上纵向遍历二叉树的层次。

BFS实现：
数据结构：队列

父节点入队，父节点出队列，先左子节点入队，后右子节点入队。递归遍历全部节点即可
 */
package Tree;

import Tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
//        System.out.println(BFS(root));
        bredth(root);
    }

    //用队列实现
    public static ArrayList<Integer> BFS(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null)
                queue.offer(tree.left);
            if (tree.right != null)
                queue.offer(tree.right);
            lists.add(tree.val);
        }
        return lists;
    }


    //递归实现
    public static void bredth(TreeNode root) {
        System.out.println(root.val);
        breadthTraversal(root);
    }

    private static void breadthTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            System.out.println(left.val);
        }
        if (right != null) {
            System.out.println(right.val);
        }
        breadthTraversal(root.left);
        breadthTraversal(root.right);
    }

}
