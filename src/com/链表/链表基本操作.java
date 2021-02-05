package com.链表;

public class 链表基本操作 {

    /**
     * 链表节点
     * data 存放数据的变量data
     * next 指向下一节点的指针next
     **/

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * 链表插入元素
     *
     * @param data  插入元素
     * @param index 插入位置
     **/

    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }

        Node insertedNode = new Node(data);

        if (size == 0) {
            //空链表
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            //插入头部
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) {
            //插入尾部
            last.next = insertedNode;
            last = insertedNode;
        } else {
            //插入中间
            Node prevNode = get(index - 1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;

    }

    /**
     * 链表删除元素
     *
     * @param index 删除的位置
     * @return
     */
    public Node remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }

        Node removeNode = null;
        if (index == 0) {
            //删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾部节点
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            //删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    /*
     *  链表修改元素
     * @param data 修改的元素
     * @param index 修改的的位置
     */
    public void update(int data, int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        int i = 0;
        Node p = head;
        while (i < index) {
            p = p.next;
            i++;
        }
        p.data = data;
    }

    /**
     * 链表查找元素
     *
     * @param index 查找的位置
     */

    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        链表基本操作 myLinkedList = new 链表基本操作();
        System.out.print("链表插入操作：");
        myLinkedList.insert(3, 0);
        myLinkedList.insert(7, 1);
        myLinkedList.insert(1, 2);
        myLinkedList.insert(8, 3);
        myLinkedList.insert(6, 4);
        myLinkedList.output();
        System.out.println("");
        System.out.print("链表删除操作：");
        myLinkedList.remove(1);
        myLinkedList.output();
        System.out.println("");
        System.out.print("链表修改操作：");
        myLinkedList.update(100, 0);
        myLinkedList.update(80, 2);
        myLinkedList.output();

    }
}
