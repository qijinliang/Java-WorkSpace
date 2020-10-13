package Leetcode.其他2.翻转字符串;

public class RotateWord {


    /**
     * 把chas 看作字符串为"dog Loves pig" 翻转成"pig Loves dog"
     * 把chas 看作字符串为"I'm a student" 翻转成"student. a I'm"
     */
    public static void main(String[] args) {

////        // char[] 类型转String类型
        char[] cs2 = {'d', 'o', 'g', 'L', 'o', 'v', 'e', 's', 'p', 'i', 'g'};
//        String str2 = String.valueOf(cs2);
//        System.out.println(str2);
        rotateWord(cs2);
        System.out.println(cs2);
    }

    public static void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
    }

    public static void reverse(char[] chas, int start, int end) {
        char tmp = 0;
        while (start < end) {
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }
}
