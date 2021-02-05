package Leetcode.链表.反转链表;


import Leetcode.链表.公共.Node;

/**
 * 实现反转单向链表
 * 时间复杂度要求O(N)
 */
public class revsrseList {

    /**
     * 单向链表反转
     * */

    public static Node revsrseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双向链表反转
     * */

    public static Node DoublerevsrseList(Node head) {
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



    public static void main(String[] args) {
        //测试单向
        System.out.println("----测试单向----");
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = Node.createList(arr, 6);
        head.printList(head);
        Node res = revsrseList.revsrseList(head);
        revsrseList(head);
        head.printList(res);
        System.out.println("----测试双向----");
        //测试双向
        int[] DoubleArr = {1, 2, 3, 4, 5, 6};
        Node DoubleHead = Node.createList(DoubleArr, 6);
        DoubleHead.printList(DoubleHead);
        Node DoubleRes = revsrseList.DoublerevsrseList(DoubleHead);
        DoublerevsrseList(DoubleHead);
        DoubleHead.printList(DoubleRes);
    }
}
