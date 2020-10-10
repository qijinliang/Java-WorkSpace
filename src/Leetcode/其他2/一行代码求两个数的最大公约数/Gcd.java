package Leetcode.其他2.一行代码求两个数的最大公约数;

public class Gcd {

    public static void main(String[] args) {

        System.out.println( gcd(4,2));
    }

    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
