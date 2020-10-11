package Leetcode.其他2.KMP算法;

public class GetindeOf {

    /***
     * 给定两个字符串str和mach，长度分别为N和M
     * 实现一个算法，如果字符串str中含有match，则返回match在str中的开始位置
     * 不含则返回-1
     */

    //str = "acbc" , match = "bc" 返回2
    //str = "acbc", match = "bcc" 返回-1
    public static void main(String[] args) {
        System.out.println(getIndexOf("acbc", "bc"));
        System.out.println(getIndexOf("acbc", "bcc"));
    }

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
