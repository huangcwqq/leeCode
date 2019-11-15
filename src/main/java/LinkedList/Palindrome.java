/*
请判断一个链表是否为回文链表。

示例 1:
输入: 1->2
输出: false

示例 2:
输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

package LinkedList;

import LinkedList.entity.ListNode;

public class Palindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head2));

    }

    //将链表前半段置反，和后半段依次比较
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != slow) {
            ListNode curNext = cur.next;
            if (curNext == slow) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        //链表长度为基数时
        if (fast != null && fast.next == null) {
            slow = slow.next;
        }
        while (newHead != null) {
            if (newHead.val != slow.val) {
                return false;
            }
            newHead = newHead.next;
            slow = slow.next;
        }
        return true;
    }
}

