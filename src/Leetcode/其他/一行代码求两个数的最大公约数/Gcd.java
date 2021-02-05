package Leetcode.其他.一行代码求两个数的最大公约数;

public class Gcd {

    public static void main(String[] args) {

        System.out.println(gcd(4, 2));
    }

    /**
     * 如果q和r分别是m除于n的商及余数，即m = nq + r
     * 那么m和n的最大公约数等于n和r的最大公约数
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
