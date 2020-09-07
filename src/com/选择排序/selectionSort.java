package com.选择排序;

import java.util.Arrays;
import java.util.Scanner;

//工作原理：首先在未排序序列中找到最小（大）元素，
// 存放到排序序列的起始位置，
// 然后，再从剩余未排序元素中继续寻找最小（大）元素，
// 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
public class selectionSort {

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
        array = selectionSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(array));
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
}
