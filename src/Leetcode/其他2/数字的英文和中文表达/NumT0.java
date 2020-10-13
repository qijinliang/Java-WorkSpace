package Leetcode.其他2.数字的英文和中文表达;

public class NumT0 {

    /***
     * num = 319
     * 英文表达字符串为：Three Hundred Nineteen
     * 中文表达字符串为：三百一十九
     */

    public static void main(String[] args) {
        System.out.println(getNumEngExp(1319055000));
        System.out.println(getNumChiExp(2111229996));
    }

    /***
     * 首页看数字1~19的表达问题
     */

    public static String numTo19(int num) {
        if (num < 1 || num > 19) {
            return "";
        }
        String[] names = {
                "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Tewlve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"};
        return names[num - 1];
    }

    /***
     * 再看数字1~99的表达问题
     */

    public static String numTo99(int num) {
        if (num < 1 || num > 99) {
            return "";
        }
        if (num < 20) {
            return numTo19(num);
        }
        int high = num / 10;
        String[] tyNames = {
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        return tyNames[high - 2] + numTo19(num % 10);
    }

    /***
     * 再看数字1~999的表达问题
     */

    public static String numTo999(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num < 100) {
            return numTo99(num);
        }
        int high = num / 100;
        return numTo19(high) + " Hundred " + numTo99(num % 100);
    }

    /**
     * 最后英文表达式的主要方法
     */
    public static String getNumEngExp(int num) {
        if (num == 0) {
            return "Zero";
        }

        String res = "";
        if (num < 0) {
            res = "Negative, ";
        }
        if (num == Integer.MIN_VALUE) {
            res += "Two Billion, ";
            num %= -2000000000;
        }
        num = Math.abs(num);
        int higt = 1000000000;
        int higtIndex = 0;
        String[] names = {"Billion", "Million", "Thousand", ""};
        while (num != 0) {
            int cur = num / higt;
            num %= higt;
            if (cur != 0) {
                res += numTo999(cur);
                res += names[higtIndex] + (num == 0 ? " " : ", ");
            }
            higt /= 1000;
            higtIndex++;
        }
        return res;
    }

    /**
     * 1~9中文表达式
     */
    public static String numT09(int num) {
        if (num < 1 || num > 9) {
            return "";
        }
        String[] names = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return names[num - 1];
    }

    /**
     * 1~99中文表达式
     */
    public static String numT099(int num, boolean hasBai) {
        if (num < 1 || num > 99) {
            return "";
        }
        if (num < 10) {
            return numT09(num);
        }
        int shi = num / 10;
        if (shi == 1 && (!hasBai)) {
            return "十" + numT09(num % 10);
        } else {
            return numT09(shi) + "十" + numT09(num % 10);
        }
    }

    /**
     * 1~999中文表达式
     */
    public static String numT0999(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num < 100) {
            return numT099(num, false);
        }
        String res = numT09(num / 100) + "百";
        int rest = num % 100;
        if (rest == 0) {
            return res;
        } else if (rest >= 10) {
            res += numT099(rest, true);
        } else {
            res += "零" + numT09(rest);
        }
        return res;
    }

    /**
     * 1~9999中文表达式
     */
    public static String numT09999(int num) {
        if (num < 1 || num > 9999) {
            return "";
        }
        if (num < 1000) {
            return numT0999(num);
        }
        String res = numT09(num / 1000) + "千";
        int rest = num % 1000;
        if (rest == 0) {
            return res;
        } else if (rest >= 100) {
            res += numT0999(rest);
        } else {
            res += "零" + numT099(rest, false);
        }
        return res;
    }

    /**
     * 1~99999999中文表达式
     */
    public static String numT099999999(int num) {
        if (num < 1 || num > 99999999) {
            return "";
        }
        int wan = num / 10000;
        int rest = num % 10000;
        if (wan == 0) {
            return numT09999(rest);
        }
        String res = numT09999(wan) + "万";
        if (rest == 0) {
            return res;
        } else {
            if (rest < 1000) {
                return res + "零" + numT0999(rest);
            } else {
                return res + numT09999(rest);
            }
        }
    }

    public static String getNumChiExp(int num) {
        if (num == 0) {
            return "零";
        }
        String res = num < 0 ? "负" : "";
        int yi = Math.abs(num / 100000000);
        int rest = Math.abs((num % 100000000));
        if (yi == 0) {
            return res + numT099999999(rest);
        }
        res += numT0999(yi) + "亿";
        if (rest == 0) {
            return res;
        } else {
            if (rest < 100000000) {
                return res + "零" + numT099999999(rest);
            } else {
                return res + numT099999999(rest);
            }
        }
    }

}
