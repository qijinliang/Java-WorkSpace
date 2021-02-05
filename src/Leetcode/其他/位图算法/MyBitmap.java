package Leetcode.其他.位图算法;


public class MyBitmap {

    //每一个word是一个long类型元素，对应一个64位二进制数据
    private long[] words;
    //Bitmap的位数大小
    private int size;

    public MyBitmap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size - 1) + 1)];
    }

    /**
     * 定位Bitmap某一所对应的word
     *
     * @param bitIndex 位图的第bitIndex位
     */
    private int getWordIndex(int bitIndex) {
        //有移6位，相当于除以64
        return bitIndex >> 6;
    }

    /**
     * 判断Bitmap某一位的状态
     *
     * @param bitIndex 位图的第bitIndex位
     */
    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超时Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 判断Bitmap某一位设置为true
     *
     * @param bitIndex 位图的第bitIndex位
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超出Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    public static void main(String[] args) {
        MyBitmap bitMap = new MyBitmap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(78));
    }
}
