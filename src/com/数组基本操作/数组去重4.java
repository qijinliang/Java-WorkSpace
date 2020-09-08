package com.数组基本操作;

//第四种方式:两层循环遍历原数组，然后逐个判断是否和之后的元素重复，同时设立一个标记，用来分辨是否重复，根据标记将不重复的元素存入新数组
public class 数组去重4 {

    public static Object[] fourClear(Object[] arr) {
        int t = 0;
        //临时数组
        Object[] xinArr = new Object[arr.length];

        for (int i = 0; i < arr.length; i++) {
            //声明标记，是否重复
            boolean isRepeat = true;
            for (int j = i + 1; j < arr.length; j++) {
                //如果有重复元素，将标记为false
                if (arr[i] == arr[j]) {
                    isRepeat = false;
                    break;
                }
            }
            //标记为true表示没有重复元素
            if (isRepeat) {
                xinArr[t] = arr[i];
                t++;
            }
        }
        //去重后数组
        Object[] newArr = new Object[t];
        System.arraycopy(xinArr, 0, newArr, 0, t);
        return newArr;
    }

    public static void main(String[] args) {
        Object[] arrs = {1, 2, 3, 9, 6, 7, 45, 2, 6, 1};
        System.out.print("fourClear:");
        printArray(fourClear(arrs));
    }

    private static void printArray(Object[] arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println("");
    }
}
