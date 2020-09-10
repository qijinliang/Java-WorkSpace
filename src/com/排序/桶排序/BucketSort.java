package com.排序.桶排序;

/**
 * 桶排序 (Bucket sort)的工作的原理：
 * 假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排
 */

public class BucketSort {

    public static void main(String[] args) {
        int[] array =  {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};
        System.out.print("原数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
//        bucketSort(array);
        System.out.print("排序之后的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}