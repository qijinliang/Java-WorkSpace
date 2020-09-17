package Leetcode.链表.单链表选择排序;

import Leetcode.链表.公共.Node;

public class SelecttionSort {

    public static Node selectionSort(Node head) {
        //排序部分尾部
        Node tail = null;
        //末排序部分头部
        Node cur = head;
        //最小节点的前一个节点
        Node smallPre = null;
        //最小的节点
        Node small = null;
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public static Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 3, 2};
        Node head = Node.createList(arr,5);
        selectionSort(head);
        head.printList(head);
    }
}
