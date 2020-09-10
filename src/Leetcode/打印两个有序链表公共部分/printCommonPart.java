package Leetcode.打印两个有序链表公共部分;


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
                System.out.println(head1.value + " ");
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
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }

    public static Node LinkList2() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(6);
        Node n5 = new Node(5);
        Node n6 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }

    public static void main(String[] args) {
        Node head = LinkList();
        Node head2 = LinkList2();
        printCommonPart(head, head2);
    }
}
