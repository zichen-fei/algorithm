package com.feizc;

import com.feizc.common.ListNode;
import com.feizc.common.Utils;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode head = Utils.createLinkList(4, 10, Utils.Order.NULL);

        DeleteNode d = new DeleteNode();
        Utils.printListNode(head);
        head = d.deleteNode(head, 1);
        Utils.printListNode(head);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }

        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
}
