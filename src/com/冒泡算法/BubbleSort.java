package com.冒泡算法;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//冒泡排序算法的思想
//我们从左边开始把相邻的两个数两两做比较，当一个元素大于右侧与它相邻的元素时，交换它们之间位置；反之，它们之间的位置不发生变化。冒泡排序是一种稳定的排序算法。
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("输入要排序的值，输入的值每个值用逗号隔开:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //将字符串按照'，'拆分成字符串数组
        String[] strArray = str.split(",");
        //新建数组用来存储拆分出来的每个值
        int[] array = new int[strArray.length];
        //给数组循环遍历赋值
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        System.out.println("排序前的数组：" + Arrays.toString(array));
        //排序
        sort(array);
        System.out.println("排序后的数组：" + Arrays.toString(array));
    }

    /*
     * 用冒泡排序算法对数组进行排序
     * @param array
     * */
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
}
