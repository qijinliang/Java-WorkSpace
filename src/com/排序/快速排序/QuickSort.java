package com.排序.快速排序;

import java.util.*;

/**
 * 从数列中挑出一个元素，称为 “基准”（pivot）；重新排序数列，
 * 所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */


public class QuickSort {

    public static void main(String[] args) {

        int[] array = {6, 8, 4, 36, 73, 13, 12, 3, 15, 5, 7, 9};

        System.out.println("原始值为 ：" + Arrays.toString(array));
        QuickSort(array, 0, array.length - 1);
        System.out.println("快速排序 ：" + Arrays.toString(array));
        quickSort2(array, 0, array.length - 1);
        System.out.println("双边循环法 ：" + Arrays.toString(array));
        quickSort3(array, 0, array.length - 1);
        System.out.println("单边循环法 ：" + Arrays.toString(array));
        quickSort4(array, 0, array.length - 1);
        System.out.println("非递归 ：" + Arrays.toString(array));
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
    //最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(nlogn)　

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

    /**
     * 分治(双边循环法)
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */


    public static void quickSort2(int[] arr, int startIndex, int endIndex) {
        //递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition2(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort2(arr, startIndex, pivotIndex - 1);
        quickSort2(arr, pivotIndex + 1, endIndex);
    }


    private static int partition2(int[] arr, int startIndex, int endIndex) {
        //取出第1位位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left--;
            }
            //交换left和right指针指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot 和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }


    /**
     * 分治(单边循环法)
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */
    public static void quickSort3(int[] arr, int startIndex, int endIndex) {
        //递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition3(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort3(arr, startIndex, pivotIndex - 1);
        quickSort3(arr, pivotIndex + 1, endIndex);
    }

    private static int partition3(int[] arr, int startIndex, int endIndex) {
        //取第一位位置的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    /**
     * 非递归实现
     */
    public static void quickSort4(int[] arr, int startIndex, int endIndex) {
        //用一个集合栈来替换递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        //整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        //循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()) {
            //栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partition3(arr, param.get("startIndex"), param.get("endIndex"));
            //根据基准元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String ,Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }
}
