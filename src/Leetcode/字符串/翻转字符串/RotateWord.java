package Leetcode.字符串.翻转字符串;

public class RotateWord {


    /**
     * 把chas 看作字符串为"dog Loves pig" 翻转成"pig Loves dog"
     * 把chas 看作字符串为"I'm a student" 翻转成"student. a I'm"
     */
    public static void main(String[] args) {
        String str = "dog Loves pig";
        System.out.println(new RotateWord().rotateWord(str));

        String str2 = "I'm a student";
        System.out.println(new RotateWord().rotateWord(str2));
    }

    public static String rotateWord(String str) {
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int begin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, begin, i - 1);
                begin = i + 1;
            }
        }
        return new String(arr);
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
