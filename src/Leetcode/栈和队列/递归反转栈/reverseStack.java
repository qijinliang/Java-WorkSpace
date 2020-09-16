package Leetcode.栈和队列.递归反转栈;

import java.util.Stack;
/**
 * 一个栈依次  1，2，3，4，5
 * 那么从栈顶到栈底分别为5，4，3，2，1
 * 使用递归实现元素的逆序
 */
public class reverseStack {

    /** 设计两个递归函数
     * 递归函数一：将栈stack的栈底元素返回并移除
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    /**
     * 递归函数二：逆序一个栈，
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> t1 = new Stack<>();
        t1.push(1);
        t1.push(2);
        t1.push(3);
        t1.push(4);
        t1.push(5);
        System.out.println("t1栈为：" + t1 );
        reverse(t1);
        System.out.println("翻转之后：" + t1 );
    }
}
