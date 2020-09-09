package com.队列;

import javax.xml.soap.Node;

public class MyQueue {
    //队列元素
    private int[] array;
    //队头
    private int front;
    //队尾
    private int rear;

    public MyQueue(int capacity) {

        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 入队的元素
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     *  出队
     * */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空！");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(" " + array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myqueue = new MyQueue(6);
        myqueue.enQueue(3);
        myqueue.enQueue(5);
        myqueue.enQueue(6);
        myqueue.enQueue(8);
        myqueue.enQueue(9);
        myqueue.deQueue();
        myqueue.deQueue();
        myqueue.deQueue();
        myqueue.output();
    }
}
