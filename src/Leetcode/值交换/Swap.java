package Leetcode.值交换;

/**
 * 说明
 * 数组array {1,2,3,4} 输入 第一位的值，和第二位的值，进行交换
 * 输入 1 和 3  返回数组为 {1,4,3,2}
 **/
public class Swap {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4};
        swap(array, 1, 3);

        System.out.print(" 反转后  ");
        reverser(array);
    }

    private static void swap(int[] array, int a, int b) {
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    /**
     * 扩展
     * 数组反转 {1,2,3,4}
     * 反转后 {4,3,2,1}
     */
    public static void reverser(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp;
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(" " + array[j]);
        }
    }
}
