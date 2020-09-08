package com.数组;

public class 数组翻转 {

    //实现数组元素翻转
    public static int[] reverse(int[] arr) {
        //遍历数组
        for (int i = 0; i <arr.length / 2; i++) {
            //交换元素，因为i从0开始要减去1
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    public static void main(String[] args) {
        //测试反转方法
        int[] array = new int[]{1,23,4,5,6,8,9,10};
        System.out.println("反转前的数组为：");
        for (int elem: array) {
            System.out.print(elem + " ");
        }
        //打印反转后的元素
        array = reverse(array);
        System.out.println(" ");
        System.out.println("反转后的数组为：");
        for (int elem: array) {
            System.out.print(elem + " ");
        }
    }

}
