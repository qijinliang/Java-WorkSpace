package Leetcode.链表.公共;

public class Node {
    public int value;
    public Node next;
    public Node last;

    public Node(int data) {

        this.value = data;
    }

    // 打印链表
    public static void printList(Node head)
    {
        while (head != null)
        {
            if (head.next == null)
                System.out.println(head.value);
            else
                System.out.print(head.value + "-->");

            head = head.next;
        }
    }
}
