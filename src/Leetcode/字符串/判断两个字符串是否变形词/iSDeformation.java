package Leetcode.字符串.判断两个字符串是否变形词;

public class iSDeformation {

    /***
     * str1 = "123" str2 = "231" 返回true
     * str1 = "123" str2 = "2321" false
     */

    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chas1.length; i++) {
            map[chas1[i]]++;
        }
        for (int i = 0; i < chas2.length; i++) {
            if (map[chas2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDeformation("123", "231"));
        System.out.println(isDeformation("123", "2231"));
    }
}
