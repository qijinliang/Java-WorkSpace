package Leetcode.数组.最大公约数;

public class getCommonDivisor {

    public static int getGreatestCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }

        for (int i = small / 2; i > 1; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static int getGreatestCommonDivisor2(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisor2(big % small, small);
    }

    public static int getGreatestCommonDivisor3(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        return getGreatestCommonDivisor3(big - small, small);
    }

    public static int getGreatestCommonDivisor4(int a, int b) {
        if (a == b) {
            return a;
        }

        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor4(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatestCommonDivisor4(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor4(a, b >> 1);
        } else {

            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatestCommonDivisor4(big - small, small);
        }

    }

    public static void main(String[] args) {
        System.out.println("---------------方法一---------------");
        System.out.println(getGreatestCommonDivisor(25, 5));
        System.out.println(getGreatestCommonDivisor(100, 80));
        System.out.println(getGreatestCommonDivisor(27, 4));
        System.out.println("---------------方法二---------------");
        System.out.println(getGreatestCommonDivisor2(25, 5));
        System.out.println(getGreatestCommonDivisor2(100, 80));
        System.out.println(getGreatestCommonDivisor2(27, 4));
        System.out.println("---------------方法三---------------");
        System.out.println(getGreatestCommonDivisor3(25, 5));
        System.out.println(getGreatestCommonDivisor3(100, 80));
        System.out.println(getGreatestCommonDivisor3(27, 4));
        System.out.println("---------------方法四---------------");
        System.out.println(getGreatestCommonDivisor4(25, 5));
        System.out.println(getGreatestCommonDivisor4(100, 80));
        System.out.println(getGreatestCommonDivisor4(27, 4));
    }
}

