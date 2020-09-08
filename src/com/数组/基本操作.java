package com.数组;

/**
 * 基本操作
 */
public class 基本操作 {

    private int[] array;
    private int size;

    public 基本操作(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 获取数组的大小
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 数组插入元素
     *
     * @param element 插入元素
     * @param index   插入位置
     */
    public void insert(int element, int index) throws Exception {
        //判断访问下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        //如果实际元素达到数组容量上限，则对数组进行扩容
        if (size >= array.length) {
            resize();
        }
        //从右向左循环，将元素逐个向右移
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //腾出的位置放入元素
        array[index] = element;
        size++;
    }

    /**
     * 数组删除元素
     *
     * @param index 删除位置
     */
    public int deleted(int index) throws Exception {
        //判断访问下标是否超出范围
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        int deletedElement = array[index];
        //从左向右循环，将元素逐个向左移挪1位
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }

    /**
     * 查找元素
     *
     * @param searchValue 查找参数
     * 查找的元素如果存在则返回下标值，如果不存在，打印不存在
     */

    public int find(int searchValue) {
        int i;
        for (i = 0; i < size; i++) {
            if (array[i] == searchValue) {
                System.out.println("元素存在");
                break;
            }
        }
        if (i == size) {
            System.out.println("元素不存在");
            return -1;
        }
        System.out.print("找到的元素下标为：");
        return i;
    }

    /**
     * 修改数据
     * @param oldValue 原值
     * @param newValue 新值
     * @return修改成功返回true，修改失败返回false
     */
    public boolean modify(int oldValue,int newValue) {
        int i = find(oldValue);
        if (i == -1) {
            System.out.println("需要修改的数据不存在");
            return false;
        }else{
            array[i] = newValue;
            System.out.println("修改后的数据为：" + array[i]);
            return true;
        }
    }

    /**
     * 数组扩容
     **/
    public void resize() {
        int[] arrayNew = new int[array.length * 2];
        //从旧数组复制到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 输出数组
     **/
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        基本操作 myArray = new 基本操作(3);
        myArray.insert(3, 0);
        myArray.insert(2, 1);
        myArray.insert(9, 2);
        myArray.insert(5, 3);
        myArray.insert(6, 4);
        //抛出异常
        myArray.insert(7, 5);
        myArray.insert(8, 6);
        myArray.insert(10, 7);
        System.out.print("插入操作打印：");
        myArray.output();
        //删除操作
        System.out.println("");
        System.out.print("删除操作打印：");
        myArray.deleted(5);
        myArray.output();
        System.out.println("");
        System.out.print("数组大小：");
        System.out.println(myArray.getSize());
        System.out.print("查找元素：");
        System.out.println(myArray.find(10));
        System.out.print("修改元素：");
        myArray.modify(10,1);
        myArray.output();
    }
}
