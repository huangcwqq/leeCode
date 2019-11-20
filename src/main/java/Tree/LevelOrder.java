/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */

package Tree;

import Tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> order = levelOrder(root);
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }
    }

    //递归1
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<List<Integer>>();
        List<Integer> r = new ArrayList<Integer>();
        if (root == null) {
            return order;
        }
        r.add(root.val);
        order.add(r);
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        treeNodeList.add(root);
        extent(treeNodeList, order);
        return order;
    }

    public static List<TreeNode> extent(List<TreeNode> treeNodeList, List<List<Integer>> order) {
        if (treeNodeList.size() == 0) {
            return null;
        }
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        List<Integer> extentList = new ArrayList<Integer>();
        for (int i = 0; i < treeNodeList.size(); i++) {
            TreeNode left = treeNodeList.get(i).left;
            if (left != null) {
                nodeList.add(left);
                extentList.add(left.val);
            }
            TreeNode right = treeNodeList.get(i).right;
            if (right != null) {
                nodeList.add(right);
                extentList.add(right.val);
            }
        }
        if (extentList.size() > 0) {
            order.add(extentList);
        }
        extent(nodeList, order);
        return nodeList;
    }

    //递归2,用深度遍历记录下层数，并为每一层建立一个数组
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        DFS(root, 0, ans);
        return ans;
    }

    private static void DFS(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null) return;

        if (ans.size() <= depth) ans.add(new ArrayList());

        ans.get(depth).add(root.val);

        DFS(root.left, depth + 1, ans);
        DFS(root.right, depth + 1, ans);
    }

}
