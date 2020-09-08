package com.判断;

/*
*  质数就是只能被他自身或1整除的数字。质数定义在大于1 的自然数中。2是质数。
   思路：从2开始遍历i++，到数字本身大小之前停止，每次遍历判断这个数字能否被i整除。
   * 如果能被i整除，即num%i==0，则不是质数，返回false，否则返回true。
* */
public class 是否质数 {

    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int j = 97;
        if (isPrimeNumber(j)) {
            System.out.println("j 是质数");
        } else {
            System.out.println("j 不是质数");
        }
    }
}
