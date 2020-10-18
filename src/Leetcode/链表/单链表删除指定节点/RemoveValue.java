package Leetcode.链表.单链表删除指定节点;

import Leetcode.链表.公共.Node;

import java.util.Stack;

public class RemoveValue {

    public static Node removeValue1(Node head, int num) {
        Stack<Node> stack = new Stack<Node>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public static Node removeValue2(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        Node head = Node.createList(arr, 5);
        removeValue1(head, 4);
        removeValue2(head,5);
        head.printList(head);
    }
}
