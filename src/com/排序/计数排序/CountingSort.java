package com.排序.计数排序;

import java.util.Arrays;

/**
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {

    public static void main(String[] args) {

        int[] array = new int[]{6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        int[] array2 =  new int[]{6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        System.out.println("原始值为 ：" + Arrays.toString(array));
        array = CountingSort(array);
        System.out.println("排序之后 ：" + Arrays.toString(array));
        array2 = CountingSort2(array2);
        System.out.println("排序之后 ：" + Arrays.toString(array2));
    }

    /**
     * 计数排序
     */
    public static int[] CountingSort(int[] array) {
        // 1. 得到数列的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 2. 根据数列最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        // 3. 遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        // 4. 遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    public static int[] CountingSort2(int[] array) {
        // 1. 得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        // 2. 创建统计数组并统计对应元素的个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        // 3. 统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 4. 倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

}

//最佳情况：T(n) = O(n+k) 最差情况：T(n) = O(n+k) 平均情况：T(n) = O(n+k)