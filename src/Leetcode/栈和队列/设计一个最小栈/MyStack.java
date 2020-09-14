package Leetcode.栈和队列.设计一个最小栈;
//实现一个特殊的栈，在实现栈的基本功能的基础上，在实现返回栈中最小的元素操作。

import java.util.Stack;

/**
 * pop push getMin 操作时间复杂度O(1)
 * 设计的栈类型可以使用现成的栈结构
 */
public class MyStack {

    /**
     * 解题思路
     * 使用两个栈
     * 一个栈用来保存当前栈的元素，其功能集合一个正常的栈没有区别，这个栈标记为：stackData
     * 另一个栈用于保存每一步的最小值，这个栈标记为stackMin
     */

    public static class MyStack1 {
        //方法一
        //假设当前数据为newNum，先将其压入stackData。然后判断stackMin是否为空
        // 1. 如果为空，则newNum也压入stackMin
        // 2. 如果不为空，则比较newNum和stackMin的栈顶元素中哪一个更小
        // 3. 如果newNum更小活着两者相等，则newNum也压入stackMin
        // 4. 如果stackMin中栈顶元素小，则StackMin不压入任何内容
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
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

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return this.stackMin.peek();
        }
    }


    //方法二
    //假设当前数据为newNum，先将其压入stackData。然后判断stackMin是否为空
    // 1. 如果为空，则newNum也压入stackMin
    // 2. 如果不为空，则比较newNum和stackMin的栈顶元素中哪一个更小
    // 3. 如果newNum更小活着两者相等，则newNum也压入stackMin
    // 4. 如果stackMin中栈顶元素小，则StackMin不压入任何内容
    public static class MyStack2 {

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }


        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum < this.getmin()) {
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            return this.stackMin.peek();
        }

    }

    public static void main(String[] args) {
        int[] data = {6, 5, 4, 3, 2, 1};
        MyStack1 t1 = new MyStack1();
        for (int i = 0; i < data.length; i++) {
            t1.push(data[i]);
            System.out.println(data[i] + " 入栈");
        }
        System.out.println(t1.pop() + " 出战");
        System.out.println(t1.pop() + " 出战");
        System.out.println(t1.pop() + " 出战");
        System.out.println(t1.pop() + " 出战");
        // 四次出战之后只剩下6和5 所以最小值为5
        System.out.println("MyStack1最小值为：" + t1.getmin());

        System.out.println("======第二种方案======");
        int[] data2 = {1, 2, 3, 4, 5, 6};
        MyStack2 t2 = new MyStack2();
        for (int i = 0; i < data2.length; i++) {
            t2.push(data2[i]);
            System.out.println(data2[i] + " 入栈");
        }
        System.out.println(t2.pop() + " 出战");
        System.out.println(t2.pop() + " 出战");
        System.out.println(t2.pop() + " 出战");
        System.out.println(t2.pop() + " 出战");
        // 四次出战之后只剩下6和5 所以最小值为5
        System.out.println("MyStack2最小值为：" + t2.getmin());
    }
}