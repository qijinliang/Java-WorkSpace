package Leetcode.链表.合并有序链表;
import Leetcode.链表.公共.Node;

/**
 * 给定两个有序单链表的头节点head1和head2，合并两个有序链表
 * 合并后链表依次有序，并返回合并后链表的头节点
 *  0 > 2 > 3 > 7
 *  1 > 3 > 5 > 7 > 9
 *  合并后：0 --> 1 --> 2 --> 3 --> 3 --> 5 --> 7 --> 7 --> 9
 */

public class merge {

    public static Node merge(Node head1, Node head2) {

        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }

        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        Node.printList(head);
        return head;
    }

    /**
     * 测试
     * 创建一个链表
     */
    public static Node LinkList() {
        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static Node LinkList2() {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    public static void main(String[] args) {
        Node head1 = LinkList();
        Node head2 = LinkList2();
        merge(head1, head2);
    }

}
