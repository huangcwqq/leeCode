/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */

package LinkedList;

import LinkedList.entity.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(5);
//        l2.next.next.next.next = new ListNode(6);
        ListNode newHead = mergeTwoLists(l1, l2);
        System.out.println(newHead);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = newHead;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null) {
                temp.val = temp2.val;
                temp.next = temp2.next;
                break;
            }
            if (temp2 == null) {
                temp.val = temp1.val;
                temp.next = temp1.next;
                break;
            }
            if (temp1.val < temp2.val) {
                temp.val = temp1.val;
                temp.next = new ListNode(0);
                temp = temp.next;
                temp1 = temp1.next;
                continue;
            } else if (temp1.val > temp2.val) {
                temp.val = temp2.val;
                temp.next = new ListNode(0);
                temp = temp.next;
                temp2 = temp2.next;
                continue;
            }
            if (temp1.val == temp2.val) {
                temp.val = temp1.val;
                temp.next = new ListNode(temp2.val);
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 != null || temp2 != null) {
                    temp.next.next = new ListNode(0);
                    temp = temp.next.next;
                }
                continue;
            }
        }
        return newHead;
    }

    //大佬迭代方法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return head.next;
    }

    //大佬递归方法
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
