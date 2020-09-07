package com.判断是否有序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 思路
 * 遍历数组，如果存在 array[i] > array[i+1] 则该数组不是有序的，否则这个数组是升序
 */
public class 是否有序 {
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
        //判断是否有序
        System.out.println(isSorted(array));
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
