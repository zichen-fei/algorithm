package com.feizc;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        if (head == null) {
            return null;
        }

        Node p = head;

        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;

        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        Node copyNode;
        while (curr != null) {
            copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node copyHead = head.next;
        curr = head;
        Node currCopy = head.next;
        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;
            if (currCopy.next != null) {
                currCopy.next = currCopy.next.next;
                currCopy = currCopy.next;
            }
        }
        return copyHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
