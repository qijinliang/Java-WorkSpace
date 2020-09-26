package com.基础.程序的基本结构;
// 导入一个Java库

import java.util.Arrays;

// 文件名是BinarySearch
public class BinarySearch {

    /****
     * 静态方法
     * @param key 参数变量
     * @param a 参数变量
     * @return 返回值
     */
    public static int rank(int key, int[] a) {
        //初始化声明语句
        int lo = 0;
        int hi = a.length - 1;
        //循环语句
        while (lo <= hi) {
            //表达式
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        //返回语句
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 6, 4, 5, 6};
        //  调用本地的方法
        System.out.println(rank(10, array));
    }
}
