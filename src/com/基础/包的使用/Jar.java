package com.基础.包的使用;

import edu.princeton.cs.algs4.*;


public class Jar {

    //随机返回[a,b)之间的double值
    public static double uniform(double a, double b) {
        return a + StdRandom.random() * (b - a);
    }

    public static void main(String[] args) {
        StdOut.println(uniform(2.0, 9.0));
    }
}
