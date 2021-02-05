package Leetcode.栈和队列.栈实现队列;

import java.util.Stack;

public class StackQueue {

    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();


    /**
     * 入队操作
     *
     * @param element 入队的元素
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
     * 出队操作
     */
    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            tramser();
        }
        return stackB.pop();
    }

    /**
     * 栈A元素转移到栈B
     */
    private void tramser() {
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}
