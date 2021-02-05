package com.基础.包的使用;

import edu.princeton.cs.algs4.*;


public class Jar {

    //随机返回[a,b)之间的double值
    public static double uniform(double a, double b) {
        return a + StdRandom.random() * (b - a);
    }

    //随机返回[0..N)之间的一个int值
    public static int uniform(int N) {
        return (int) (StdRandom.random() * N);
    }

    //随机返回[lo,hi)之间的一个int值
    public static int uniform(int lo, int hi) {
        return lo + StdRandom.uniform(hi - lo);
    }

    //根据散列概率随机返回一个int值
    public static int discrete(double[] a) {
        double r = StdRandom.random();
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum >= r) return i;
        }
        return -1;
    }

    //随机double数组中的元素排序
    public static void shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }


    public static void main(String[] args) {

        StdOut.println(uniform(2.0, 9.0));
        StdOut.println(uniform(10));
        StdOut.println(uniform(10, 20));
        double[] array = {4.0, 1.0, 2.0, 5.0, 3.0};
        StdOut.println(discrete(array));
        shuffle(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
