package Leetcode.链表.链表是否为回文;

import Leetcode.链表.公共.Node;

import java.util.Stack;

/**
 * 给定一个链表的头节点Head，判断链表是否为回文结构
 * 1 > 2 > 1 返回true
 * 1 > 2 > 2 > 1 返回true
 * 1 > 2 > 3 返回false
 */
public class isPalindromel {


    /** 方法一
     *  利用栈结构，从左到右遍历链表，遍历的过程中把每个节点依次压入栈中
     *  因为栈是先进后出，所以遍历完后，从栈顶到栈底的节点值出现顺序会与原链表从左到右的值出现顺序反过来
     *  那么，如果一个链表回文结构逆序之后，值出现的次序还是一样的，如果不是回文，顺序对不上
     * */
    private static boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /** 方法二对方法一进行了优化，也是利用了栈结构，只用一半的节点
     * 设链表长度为N，N为偶数，前N/2的节点叫做左半区，后N/2节点叫做右半区
     * 如果N是奇数，还是一样
     * */

    private static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 不需要栈和其他数据结构，只用有限几个变量，其额外空间浮渣度O(1)
     * 就可以在时间复杂度O(N)内完成所有的过程，也就是满足进阶的要求
     * */
    private static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        //查找重点节点
        while (n2.next != null && n2.next.next != null) {
            // n1 -> 中部
            n1 = n1.next;
            // n2 -> 尾部
            n2 = n2.next.next;
        }
        // n2 -> 右部分第一个节点
        n2 = n1.next;
        // mid.next -> null
        n1.next = null;
        Node n3 = null;
        // 右半区反转
        while (n2 != null) {
            // n3 -> 保存下一个节点
            n3 = n2.next;
            // 下一个节点反转
            n2.next = n1;
            // n1 移动
            n1 = n2;
            // n2 移动
            n2 = n3;
        }
        // n3 -> 保存最后一个节点
        n3 = n1;
        // n2 -> 左边第一个节点
        n2 = head;
        boolean res = true;
        // 检查回文
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            // 从左到中部
            n1 = n1.next;
            // 从右到中部
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        // 恢复列表
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));
        System.out.println(isPalindrome3(head));
    }

}
