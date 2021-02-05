package Leetcode.其他.蓄水池算法;

import java.util.Arrays;

public class GetKNumsRand {


    /***
     * 一个简单的随机函数，决定一件事做还是不做
     * @param max
     */
    public static int rand(int max) {
        return (int) (Math.random() * max) + 1;
    }

    public static int[] getKNumsRand(int k, int max) {
        if (max < 1 || k < 1) {
            return null;
        }
        int[] res = new int[Math.min(k, max)];
        for (int i = 0; i != res.length; i++) {
            res[i] = i + 1;
        }
        for (int i = k + 1; i < max + 1; i++) {
            if (rand(i) <= k) {
                res[rand(k) - 1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKNumsRand(20, 100)));

    }
}
