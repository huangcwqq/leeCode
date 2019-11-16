/*
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。



示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。


进阶：

你能用 O(1)（即，常量）内存解决此问题吗？
 */
package LinkedList;

import LinkedList.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(0);
        head.next.next.next = head;
//        head.next.next.next = new ListNode(4);
        System.out.println(hasCycle2(head));
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            if (nodeSet.contains(temp)) {
                return true;
            }
            nodeSet.add(temp);
            temp = temp.next;
        }
        return false;
    }

    //把所有的前置节点都指向首节点
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode h = head;
        while (head.next != h) {
            ListNode temp = head;
            if (temp.next == null) {
                return false;
            }
            head = head.next;
            temp.next = h;
        }
        return true;
    }

    //利用快慢指针
    public static boolean hasCycle3(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
