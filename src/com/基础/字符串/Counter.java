package com.基础.字符串;

import edu.princeton.cs.algs4.*;

public class Counter {

    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        heads.increment();
        heads.increment();
        tails.increment();
        StdOut.println(heads + " " + tails);
    }

}
