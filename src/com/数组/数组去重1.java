package com.数组;

import java.util.HashSet;
import java.util.Set;

//第一种方式:最开始想到的是利用Set集合的不可重复性进行元素过滤
public class 数组去重1 {
    public static Object[] oneClear(Object[] arr) {
        Set set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.toArray();
    }

    public static void main(String[] args) {
        Object[] arrs = {1, 2, 3, 7, 6, 7, 5, 2, 6, 1};
        System.out.print("oneClear:");
        printArray(oneClear(arrs));
    }

    private static void printArray(Object[] arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println("");
    }
}

