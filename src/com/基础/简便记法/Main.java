package com.基础.简便记法;

public class Main {

    static int[] a = {1, 5, 6, 7, 8, 9};

    //找出数组中最大的元素
    public static void Testament() {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        System.out.println("最大元素为：" + max);
    }

    //计算数组元素的平均值
    public static void Theaverage() {
        int N = a.length;
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum += a[i];
        }
        double average = sum / N;
        System.out.println("平均值为：" + average);
    }


    public static void main(String[] args) {
        Testament();
        Theaverage();
    }
}
