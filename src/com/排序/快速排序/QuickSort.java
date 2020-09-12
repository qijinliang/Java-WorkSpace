package com.排序.快速排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 从数列中挑出一个元素，称为 “基准”（pivot）；重新排序数列，
 * 所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */


public class QuickSort {

    public static void main(String[] args) {

        int[] array = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        int[] array2 = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        int[] array3 = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        int[] array4 = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        System.out.println("原始值为 ：" + Arrays.toString(array));
        QuickSort(array,0,array.length - 1);
        System.out.println("快速排序 ：" + Arrays.toString(array));

    }


    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end)
            return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
//最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(nlogn)　