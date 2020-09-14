package Leetcode.栈和队列.用一个栈实现另一个栈的排序;
import java.util.Stack;

/**
 * 一个栈中元素的类型为整型，将该栈从顶到底按大到小的顺序排序
 * 只申请一个栈，可以申请新的变量
 */
public class sortStack {


    private final Stack<Integer> stackData;
    private final Stack<Integer> stackMin;

    public sortStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }
    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return this.stackMin.peek();
    }


    /**
     * 解题思路
     * 将要排序的栈标记为stack，申请的辅助栈标记为help
     * 在stack上执行pop操作，弹出的元素为cur
     * 1.如果cur小于或等于help的栈顶元素，则将cur直接压入hlep
     * 2.如果cur大于help的栈顶元素，则将help的元素逐一弹出，逐一压入stack
     * 直到cur小于或等于help的栈顶元素，再将cur压入help
     * 3.一直执行以上操作，直到stack中的全部元素都压入到help。最后将help中的所有元素逐一压入stack
     * */

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }


    public static void main(String[] args) {
        Stack<Integer> t1 = new Stack<>();
        t1.push(2);
        t1.push(1);
        t1.push(6);
        t1.push(4);
        t1.push(10);
        t1.push(5);
        System.out.println("栈为：" + t1 );
        sortStackByStack(t1);
        System.out.println("排序之后：" + t1 );
    }
}
