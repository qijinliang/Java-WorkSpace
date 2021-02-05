package Leetcode.字符串.字符串求和;

public class NumSum {

    /***
     * str = "A1CD2E33" 返回36
     * str = "A-1B--2C--D6E" 返回7
     */

    public static int numSum(String str) {
        if (str == null) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSum("A1CD2E33"));
        System.out.println(numSum("A-1B--2C--D6E"));
    }
}
