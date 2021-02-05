package Leetcode.字符串.去掉字符串连续出现k哥0子串;

public class KZeros {

    /***
     * 给定一个字符串str和一个整数k，如果str中正好有连续k个0字符出现时
     * 把k个连续'0'字符去掉
     * str = "A00B" k = 2 返回"A00B"
     * str = "A0000B000" k = 3 返回"A0000B"
     */

    public static String removeKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }
        char[] chas = str.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i != chas.length; i++) {
            if (chas[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0)
                        chas[start++] = 0;
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0)
                chas[start++] = 0;
        }
        return String.valueOf(chas);
    }


    public static void main(String[] args) {
        System.out.println(removeKZeros("AOOB", 2));
        System.out.println(removeKZeros("A0000B000", 3));
    }
}
