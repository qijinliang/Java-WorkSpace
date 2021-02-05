package com.数组;

import java.util.LinkedHashSet;

//第二种方式:要想保持原数组的顺序就使用有顺序、不重复特点的链表的哈希集合
public class 数组去重2 {


    public static Object[] twoClear(Object[] arr) {
        LinkedHashSet<Object> temp = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        return temp.toArray();
    }

    public static void main(String[] args) {
        Object[] arrs = {1, 2, 3, 7, 6, 7, 5, 2, 6, 1};
        System.out.print("twoClear:");
        printArray(twoClear(arrs));

    }

    private static void printArray(Object[] arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println("");
    }
}
