package com.排序.选择排序;

import java.util.Arrays;


//工作原理：首先在未排序序列中找到最小（大）元素，
// 存放到排序序列的起始位置，
// 然后，再从剩余未排序元素中继续寻找最小（大）元素，
// 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
public class selectionSort {

    public static void main(String[] args) {

        int[] array =  {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        System.out.println("原始值为 ：" + Arrays.toString(array));
        selectionSort(array);
        System.out.println("排序之后 ：" + Arrays.toString(array));
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex])  //找到最小的数
                    minIndex = j; //将最小的数索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /*
     * 最佳情况：T(n) = O(n2) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
     * */
}
