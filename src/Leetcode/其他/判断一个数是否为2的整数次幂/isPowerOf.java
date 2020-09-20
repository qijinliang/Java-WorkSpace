package Leetcode.其他.判断一个数是否为2的整数次幂;

public class isPowerOf {

    public static boolean isPower2(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp * 2;
        }
        return false;
    }

    public static boolean isPower2_2(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp << 1;
        }
        return false;
    }

    public static boolean isPower2_3(int num) {

        return (num&num-1) == 0;
    }

    public static void main(String[] args) {
        System.out.println("---------------方法一---------------");
        System.out.println(isPower2(32));
        System.out.println(isPower2(19));
        System.out.println("---------------方法二---------------");
        System.out.println(isPower2_2(32));
        System.out.println(isPower2_2(19));
        System.out.println("---------------方法三---------------");
        System.out.println(isPower2_3(32));
        System.out.println(isPower2_3(19));
    }
}
