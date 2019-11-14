/*
反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

package LinkedList;

import LinkedList.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        ListNode newHead = reverseList2(head);
        System.out.println(newHead);
    }

    //引入List记录下链表的各个值，然后倒序生成另外的链
    public static ListNode reverseList(ListNode head) {
        List<Integer> nodeList = new ArrayList<Integer>();
        ListNode temp = head;
        while (temp != null) {
            nodeList.add(temp.val);
            temp = temp.next;
        }
        ListNode temp2 = head;
        for (int i = nodeList.size() - 1; i > -1; i--) {
            temp2.val = nodeList.get(i);
            temp2 = temp2.next;
        }
        return head;
    }

    //递归方法
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    //迭代方法
    public static ListNode reverseList3(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
