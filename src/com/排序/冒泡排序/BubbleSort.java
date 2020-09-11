package com.排序.冒泡排序;

import java.util.Arrays;
import java.util.Scanner;

//冒泡排序算法的思想
//我们从左边开始把相邻的两个数两两做比较，当一个元素大于右侧与它相邻的元素时，交换它们之间位置；
// 反之，它们之间的位置不发生变化。冒泡排序是一种稳定的排序算法。
public class BubbleSort {
    public static void main(String[] args) {

        int[] array =  {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        System.out.print("原数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        sort(array);
        System.out.print("排序之后的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }


    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    private static void sort(int[] array) {
        //array.length - 1 是因为最后一轮不需要排序
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("第" + (i + 1) + "趟");
            //array.length - i 是因为每一轮都能确定排序好一个数
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                System.out.println("第" + (j + 1) + "次：" + Arrays.toString(array));
            }
        }
    }

    /*
    * 最佳情况：T(n) = O(n) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
    * */
}
