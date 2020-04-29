package com.feizc;

import com.feizc.common.ListNode;

import java.util.Stack;

/**
 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

        System.out.println("=========");

        MinStack2 minStack2 = new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        System.out.println(minStack2.min());
        minStack2.pop();
        System.out.println(minStack2.top());
        System.out.println(minStack2.min());
    }

    //LinkedList
    public static class MinStack2 {
        private ListNode head;

        public MinStack2() {

        }

        public void push(int x) {
            if (head == null) {
                head = new ListNode(x, x, null);
            } else {
                head = new ListNode(x, Math.min(head.min, x), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int min() {
            return head.min;
        }
    }

    //Stack
    public static class MinStack1 {
        Stack<Integer> s;

        Stack<Integer> sup;

        public MinStack1() {
            s = new Stack<>();
            sup = new Stack<>();
        }

        public void push(int x) {
            s.push(x);
            if (sup.empty() || sup.peek() > x) {
                sup.push(x);
            } else {
                sup.push(sup.peek());
            }
        }

        public void pop() {
            s.pop();
            sup.pop();
        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return sup.peek();
        }
    }


}
