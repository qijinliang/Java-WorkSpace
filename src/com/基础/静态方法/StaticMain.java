package com.基础.静态方法;

import javax.crypto.Mac;

public class StaticMain {

    //计算一个整数的绝对值
    public static int abs(int x) {
        if (x < 0) return -x;
        else return x;
    }

    //计算一个浮点数的绝对值
    public static double abs(double x) {
        if (x < 0.0) return -x;
        else return x;
    }

    //判断一个数是否是素数
    public static boolean isPrimeNumber(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }

    //计算平方根
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t)
            t = (c / t + t) / 2.0;
        return t;
    }

    //计算直角三角形的斜边
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    //计算调和级数
    public static double H(int N) {
        double sum = 0.0;
        for (int i = 1; i <= N; i++)
            sum += 1.0 / i;
        return sum;
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    public static void main(String[] args) {
        System.out.println(abs(-100));
        System.out.println(abs(-90.0));
        System.out.println(isPrimeNumber(4));
        System.out.println(sqrt(4.0));
        System.out.println(hypotenuse(5.0, 4.0));
        System.out.println(H(5));
        int[] array = {4, 1, 2, 5, 3};
        System.out.println(rank(3, array));
    }
}
