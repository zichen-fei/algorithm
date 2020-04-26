package com.feizc;

import com.feizc.common.ListNode;
import com.feizc.common.Utils;

/**
 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        ListNode linkList = Utils.createLinkList(4, 10, Utils.Order.NULL);
        Utils.printListNode(linkList);
        linkList = r.reverseList(linkList);
        Utils.printListNode(linkList);
    }

    //头插法
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode(head.val);
        ListNode curr;
        head = head.next;
        while (head != null) {
            curr = new ListNode(head.val);
            curr.next = root;
            root = curr;
            head = head.next;
        }
        return root;
    }
}
