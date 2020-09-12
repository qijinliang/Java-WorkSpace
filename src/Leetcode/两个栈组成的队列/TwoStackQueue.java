package Leetcode.两个栈组成的队列;


import java.util.Stack;

/**
 * 用两个栈实现队列，支持 add poll peek操作
 */
public class TwoStackQueue {

    /**
     * 栈的特点是先进后出，而队列的特点是先进先出
     * 用两个栈正好把顺序反过来实现类似队列的操作
     */
    //1. 一个战作为压入栈，在压入数据时只往这个栈中压入，记为stackPush
    //2. 另一个栈只作为弹出栈，在弹出数据时只从这个栈弹出，记为stackPop
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("队列为空");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("队列为空");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        int[] data = {6, 5, 4, 3, 2, 1};
        TwoStackQueue t1 = new TwoStackQueue();
        for (int i = 0; i < data.length; i++) {
            t1.add(data[i]);
            System.out.println("add()：" + data[i]);
        }
        System.out.println("偷偷看一眼peek()：" + t1.peek());
        System.out.println("poll()：" + t1.poll());
    }
}
