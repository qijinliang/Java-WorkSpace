package Leetcode.栈和队列.判断是否有序;

/**
 * 思路
 * 遍历数组，如果存在 array[i] > array[i+1] 则该数组不是有序的，否则这个数组是升序
 */
public class ISSorted {
    public static void main(String[] args) {
        //判断是否有序
        int[] num = {1, 3, 4, 5, 6, 7, 8, 19};
        System.out.println(isSorted(num));
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
