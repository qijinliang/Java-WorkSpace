package Leetcode.链表.公共;

public class Node {
    public int value;
    public Node next;
    public Node last;

    public Node(int data) {

        this.value = data;
    }

    //创建链表
    public static Node createList(int arr[], int n) {
        if (n == 0) {
            return null;
        }
        // 将数组的第一个元素赋值给头指针
        Node head = new Node(arr[0]);
        Node curNode = head;
        //依次赋值
        for (int i = 1; i < n; i++) {
            curNode.next = new Node(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    // 打印链表
    public static void printList(Node head) {
        while (head != null) {
            if (head.next == null)
                System.out.println(head.value);
            else
                System.out.print(head.value + "-->");

            head = head.next;
        }
    }
}
