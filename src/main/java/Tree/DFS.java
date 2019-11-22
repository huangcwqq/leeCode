/*
深度优先遍历：从根节点出发，沿着左子树方向进行纵向遍历，直到找到叶子节点为止。然后回溯到前一个节点，进行右子树节点的遍历，直到遍历完所有可达节点为止。

DFS实现：
数据结构：栈

父节点入栈，父节点出栈，先右子节点入栈，后左子节点入栈。递归遍历全部节点即可
 */

package Tree;

import Tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(5);
//        System.out.println(DFS(root));
        preIterator(root);
        inIterator(root);
        postIterator(root);

        preStackIterator(root);
        inStackIterator(root);
        postStackIterator(root);
    }


    //用栈实现
    public static ArrayList<Integer> DFS(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if (root == null)
            return lists;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode TreeNode = stack.pop();
            //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if (TreeNode.right != null)
                stack.push(TreeNode.right);
            if (TreeNode.left != null)
                stack.push(TreeNode.left);
            lists.add(TreeNode.val);
        }
        return lists;
    }

    //前序：访问根节点=>左子树=>右子树

    /**
     * 递归的前序遍历
     *
     * @param root
     */
    public static void preIterator(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preIterator(root.left);
            preIterator(root.right);
        }
    }

    //中序：左子树=>访问根节点=>右子树

    /**
     * 递归的中序遍历
     *
     * @param root
     */
    public static void inIterator(TreeNode root) {
        if (root != null) {
            inIterator(root.left);
            System.out.print(root.val + " ");
            inIterator(root.right);
        }
    }
    //后序：左子树=>右子树=>访问根节点

    /**
     * 递归的后序遍历
     *
     * @param root
     */
    public static void postIterator(TreeNode root) {
        if (root != null) {
            postIterator(root.left);
            postIterator(root.right);
            System.out.print(root.val + " ");
        }
    }


    /**
     * 非递归的深度前序遍历
     *
     * @param root
     */
    public static void preStackIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    /**
     * 非递归的深度中序遍历
     *
     * @param root
     */
    public static void inStackIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null)
            return;
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null)
                temp = temp.right;
            else
                temp = null;
        }
    }


    /**
     * 非递归的深度后序遍历
     *
     * @param root
     */
    public static void postStackIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null)
            return;
        TreeNode temp = root;
        stack.push(temp);
        TreeNode ptr = root, pre = null;
        while (!stack.isEmpty()) {
            ptr = stack.peek();
            if (pre != ptr.right && pre != ptr.left) {
                if (ptr.right != null)
                    stack.push(ptr.right);
                if (ptr.left != null)
                    stack.push(ptr.left);
            }
            if (ptr.left == null && ptr.right == null || pre == ptr.left
                    || pre == ptr.right) {
                System.out.print(ptr.val + " ");
                stack.pop();
            }
            pre = ptr;
        }
    }


}
