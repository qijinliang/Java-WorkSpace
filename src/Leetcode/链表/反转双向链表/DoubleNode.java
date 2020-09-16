package Leetcode.链表.反转双向链表;

import Leetcode.链表.公共.Node;

public class DoubleNode {
    public static Node revsrseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 测试
     * 创建一个链表
     */
    public static Node LinkList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }


    public static void main(String[] args) {
        Node head = LinkList();
        head.printList(head);
        Node res = DoubleNode.revsrseList(head);
        head.printList(res);
    }
}
