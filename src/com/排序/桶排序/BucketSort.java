package com.排序.桶排序;


import java.util.Arrays;

/**
 * 桶排序 (Bucket sort)的工作的原理：
 * 假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排
 */

public class BucketSort {

    public static void main(String[] args) {
//        int[] array = {6,8,4,36,73,13,12,3,15,5,7,9};
        int[] array = {9,8,7,6,4,5,2,3,1};
        System.out.print("原数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        bucketSort(array);
        System.out.print("排序之后的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        //根据原始序列的长度，设置桶的数量。这里假设每个桶最多放4个元素
        int bucketCount = len / 3;
        //遍历原始序列，找出最大值和最小值
        int min = 0, max = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        //每个桶的数值范围
        int range = (max - min + 1) / bucketCount;
        int[][] buckets = new int[bucketCount][];
        //遍历原始序列
        for (int i = 0; i < len; i++) {
            int val = arr[i];
            //计算当前值属于哪个桶
            int bucketIndex = (int) Math.floor((val - min) / range);
            //向桶中添加元素
            buckets[bucketIndex] = appendItem(buckets[bucketIndex], val);
        }
        // 最后合并所有的桶
        int k = 0;
        for (int[] b : buckets) {
            if (b != null) {
                for (int i = 0; i < b.length; i++) {
                    arr[k++] = b[i];
                }
            }
        }
    }

    public static int[] appendItem(int[] bucketArr, int val) {
        if (bucketArr == null || bucketArr.length == 0) {
            return new int[]{val};
        }
        //拷贝一下原来桶的序列，并增加一位
        int[] arr = Arrays.copyOf(bucketArr, bucketArr.length + 1);
        //这里使用插入排序，将新的值val插入到序列中
        int i;
        for (i = arr.length - 2; i >= 0 && arr[i] > val; i--) {
            //从新序列arr的倒数第二位开始向前遍历
            //如果当前序列值大于val，那么向后移动
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = val;
        return arr;
    }
}
//最佳情况：T(n) = O(n+k) 最差情况：T(n) = O(n+k) 平均情况：T(n) = O(n2)　　