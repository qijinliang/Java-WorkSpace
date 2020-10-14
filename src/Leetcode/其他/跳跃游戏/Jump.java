package Leetcode.其他2.跳跃游戏;


import java.util.Arrays;

public class Jump {

    /***
     * 给定数组arr arr[i] == k 代表可以从位置i向右跳1~k个距离
     * 比如arr[2] == 3代表从位置2可以跳跃到位置3,位置4或者位置5
     */
    public static int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next,i+arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 3, 4, 5, 10, 9};
        System.out.println(jump(array));
    }
}
