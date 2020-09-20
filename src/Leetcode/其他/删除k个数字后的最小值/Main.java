package Leetcode.其他.删除k个数字后的最小值;

public class Main {

    /** 删除整数的k个数字，获得删除后的最小值
     * @param num 原整数
     * @param k 删除数量
     * */
    public static String removeDigits(String num, int k) {
        String numNew = num;

        return numNew;
    }

    private static String removeZero(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(0) != '0'){
                break;
            }
            num = num.substring(i,num.length());
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(removeDigits("1593212",3));
        System.out.println(removeDigits("30200",1));
        System.out.println(removeDigits("10",2));
        System.out.println(removeDigits("541270936",3));
    }
}
