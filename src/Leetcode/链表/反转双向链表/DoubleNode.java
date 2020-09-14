package Leetcode.链表.反转双向链表;

public class DoubleNode {
    public int value;

    public DoubleNode last;

    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }

    public static DoubleNode revsrseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
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
    public static DoubleNode LinkList() {
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);
        DoubleNode n5 = new DoubleNode(5);
        DoubleNode n6 = new DoubleNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }


    public static void main(String[] args) {
        DoubleNode head = LinkList();
        DoubleNode res = DoubleNode.revsrseList(head);
        for (DoubleNode cur = res; cur != null; cur = cur.next) {
            System.out.print(" " + cur.value);
        }
    }
}
