package com.基础.简便记法;

import java.util.Arrays;

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

    //复制数组
    public static void coypArray() {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < N; i++)
            b[i] = a[i];

        System.out.println("B复制后为：" + Arrays.toString(b));
    }

    //颠倒数组元素的顺序
    public static void Temp() {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            double temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - i - 1] = (int) temp;

        }
        System.out.println("颠倒和的顺序为：" + Arrays.toString(a));
    }

    //矩阵相乘
    public static void matrix() {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 1, 2, 3}};
        int[][] b = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int arow = a.length;
        int bcol = b[0].length;
        int m = b.length;
        int[][] c = new int[arow][bcol];
        for (int i = 0; i < arow; i++) {
            for (int j = 0; j < bcol; j++) {
                int result = 0;
                for (int k = 0; k < m; k++) {
                    result += a[i][k] * b[k][j];
                }
                c[i][j] = result;
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Testament();
        Theaverage();
        coypArray();
        Temp();
        matrix();
    }
}
