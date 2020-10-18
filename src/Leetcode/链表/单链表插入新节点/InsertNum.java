package Leetcode.链表.单链表插入新节点;
import Leetcode.链表.公共.Node;

public class InsertNum {

    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 3, 2};
        Node head = Node.createList(arr,5);
        insertNum(head,5);
        head.printList(head);
    }
}
