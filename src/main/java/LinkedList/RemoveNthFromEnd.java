/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.

说明：
给定的 n 保证是有效的。

进阶：
你能尝试使用一趟扫描实现吗？
 */

package LinkedList;

import LinkedList.entity.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = removeNthFromEnd(head,1);
        System.out.println(newHead);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        Map<Integer,ListNode> nodeMap = new HashMap<Integer, ListNode>();
        int count = 1;
        ListNode temp = head;
        while(temp != null){
            nodeMap.put(count,temp);
            temp = temp.next;
            count++;
        }
        if(n == 1){
            nodeMap.get(count - n - 1).next = null;
            return head;
        }
        ListNode removeNode = nodeMap.get(count - n);
        removeNode.val = removeNode.next.val;
        removeNode.next = removeNode.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode l1=head;
        ListNode l2 = head;
        while(n>0){
            l1=l1.next;
            n--;
        }
        if(l1==null) return head.next;
        while(l1.next!=null){
            l1=l1.next;
            l2=l2.next;
        }
        l2.next=l2.next.next;
        return head;
    }
}
