package Leetcode.其他.寻找排列的下一个数;

import java.util.Arrays;

public class Main {

    public static int[] findNearestNumber(int[] numbers) {
        //1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数组置换的边界
        int index = findTransferPoint(numbers);
        // 如果数字置边界是0，说明整个数组已经是逆序，无法得到更大的相同数字组成的整数，返回null
        if (index == 0) {
            return null;
        }
        //2. 把逆序区域的前一位和逆序区域中港港大于他的数字交换位置
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy,index);
        //3. 把原来的逆序区域转为顺序
        reverse(numbersCopy,index);
        return numbersCopy;
    }
    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i-1]) {
                return i;
            }
        }
        return 0;
    }


    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] num, int inedx) {
        for (int i = inedx, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        //打印12345 之后的10全排列整数
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    /**
     * 输出数组
     */
    private static void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i);
        }
        System.out.println();
    }
}
