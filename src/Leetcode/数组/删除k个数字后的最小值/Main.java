package Leetcode.其他.删除k个数字后的最小值;

public class Main {

    /**
     * 删除整数的k个数字，获得删除后的最小值
     *
     * @param num 原整数
     * @param k   删除数量
     */
    public static String removeDigits(String num, int k) {
        String numNew = num;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            //从左向右遍历，找到比自己右侧数字大的数字并删除
            for (int j = 0; j < numNew.length() - 1; j++) {
                if (numNew.charAt(j) > numNew.charAt(j + 1)) {
                    numNew = numNew.substring(0, j) + numNew.substring(j + 1, numNew.length());
                    hasCut = true;
                    break;
                }
            }
            //如果没有找到要删除的数字，则删除最后一个数字
            if (!hasCut) {
                numNew = numNew.substring(0, numNew.length() - 1);
            }
            //清楚整数左侧的数字0
            numNew = removeZero(numNew);
        }
        //如果整数的所有数字都被删除了，则返回0
        if (numNew.length() == 0) {
            return "0";
        }
        return numNew;
    }

    private static String removeZero(String num) {
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(0) != '0') {
                break;
            }
            num = num.substring(i, num.length());
        }
        return num;
    }

    /**
     * 删除整数的k个数字，获得删除后的最小值
     *
     * @param num 原整数
     * @param k   删除数量
     */
    public static String removeDigits2(String num, int k) {
        //新整数的最终长度 = 原整数长度-k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出站
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;
        }
        //找到栈中第1个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength? "0" : new String(stack, offset, newLength - offset);
    }

    public static void main(String[] args) {
        System.out.println(removeDigits("1593212", 3));
        System.out.println(removeDigits("30200", 1));
        System.out.println(removeDigits("10", 2));
        System.out.println(removeDigits("541270936", 3));
        System.out.println("--------方法二--------");
        System.out.println(removeDigits2("1593212", 3));
        System.out.println(removeDigits2("30200", 1));
        System.out.println(removeDigits2("10", 2));
        System.out.println(removeDigits2("541270936", 3));
    }
}
