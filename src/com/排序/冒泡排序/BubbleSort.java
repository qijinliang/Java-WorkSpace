package com.排序.冒泡排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//冒泡排序算法的思想
//我们从左边开始把相邻的两个数两两做比较，当一个元素大于右侧与它相邻的元素时，交换它们之间位置；
// 反之，它们之间的位置不发生变化。冒泡排序是一种稳定的排序算法。
public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        int[] array2 = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        int[] array3 = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        int[] array4 = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        System.out.println("原始值为 ：" + Arrays.toString(array));
        sort(array);
        System.out.println("冒泡排序 ：" + Arrays.toString(array));
        sort2(array2);
        System.out.println("冒泡优化2：" + Arrays.toString(array2));
        sort3(array3);
        System.out.println("冒泡优化3：" + Arrays.toString(array3));
        sort4(array4);
        System.out.println("鸡尾酒排序：" + Arrays.toString(array4));
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
            //array.length - i 是因为每一轮都能确定排序好一个数
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /*
     * 最佳情况：T(n) = O(n) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
     * */

    //优化2
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为元素交换，所以不是有序的，标记为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    //优化3
    public static void sort3(int[] array) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要必到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //因为有元素进行交换，所以不是有序的，标记为
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    //鸡尾酒排序
    public static void sort4(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮，从左向比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换，所有不是有序的，标记为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            //在偶数轮之前，将isSorted重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    //有元素交换，所有不是有序的，标记为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
