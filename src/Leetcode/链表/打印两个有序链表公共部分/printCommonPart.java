package Leetcode.链表.打印两个有序链表公共部分;


/** 解题思路
 * 如果head1的值小于head2，则head1往下移
 * 如果head2的值小于head1，则head2往下移
 * 如果head1的值等于head2的值相等，则打印这个值，然后head1与head2都往下移动
 * head1或head2有任何一个移动到null，整个过程停止
 * */

public class printCommonPart {

    public static class Node {
        public int value;

        public Node next;

        public Node(int data) {

            this.value = data;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
        System.out.println("公共的部分为：");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    /**
     * 测试
     * 创建一个链表
     */
    public static Node LinkList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static Node LinkList2() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static void main(String[] args) {
        Node head = LinkList();
        Node head2 = LinkList2();
        printCommonPart(head, head2);
    }
}
