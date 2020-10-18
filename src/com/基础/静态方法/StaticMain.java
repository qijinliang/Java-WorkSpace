package com.基础.静态方法;

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

    public static void main(String[] args) {
        System.out.println(abs(-100));
        System.out.println(abs(-90.0));
        System.out.println(isPrimeNumber(4));
    }
}
