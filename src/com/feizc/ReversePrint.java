package com.feizc;

import com.feizc.common.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        ReversePrint r = new ReversePrint();
        r.stack(head);
    }

    public int[] stack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            arr[i] = stack.pop();
            i++;
        }
        return arr;
    }
}
