package com.feizc;

import com.feizc.common.ListNode;
import com.feizc.common.Utils;

/**
 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists m = new MergeTwoLists();
        ListNode linkList1 = Utils.createLinkList(4, 10, Utils.Order.ASC);
        ListNode linkList2 = Utils.createLinkList(4, 10, Utils.Order.ASC);
        Utils.printListNode(linkList1);
        Utils.printListNode(linkList2);
        ListNode head = m.mergeTwoLists(linkList1, linkList2);
        Utils.printListNode(head);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
               curr.next = l1;
               l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        return root.next;
    }
}
