package com.数组;

import java.util.ArrayList;
import java.util.List;

///第三种方式:创建一个list集合，然后遍历数组将元素放入集合，再用contains()方法判断一个集合中是否已存在
public class 数组去重3 {

    public static Object[] threeClear(Object[] arr) {
        List list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        return list.toArray();
    }

    public static void main(String[] args) {
        Object[] arrs = {1, 2, 3, 45, 6, 7, 5, 2, 6, 1};
        System.out.print("threeClear:");
        printArray(threeClear(arrs));
    }

    private static void printArray(Object[] arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println("");
    }
}
