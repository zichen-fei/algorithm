package com.feizc.common;

public class ListNode {

    public int val;
    public int min;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
