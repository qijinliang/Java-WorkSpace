package com.哈希表;

/**
 * 在开放地址法中，如果我们发现有冲突(即哈希化得到下标位置已经有值了)，
 * 是通过再寻找一个空白位置，也解决冲突。根本原因是数组对应下标只能存放一个值。
 * */

public class 哈希冲突 {

    private String data;

    /**
     * 用deleteItem这个静态变量标记已经删除元素
     * 因为在链表删除的时候，是不能将数组的元素位置null，用这个标记
     */
    public static final 哈希冲突 deleteItem = new 哈希冲突();

    public 哈希冲突() {

    }

    public 哈希冲突(String data) {
        this.data = data;
    }

    public String getData() {

        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof 哈希冲突)) return false;
        哈希冲突 other = (哈希冲突) obj;
        return this.data == other.data;
    }


    /**
     * 用来缓存has值，避免每次都计算hashCode值
     */
    private int hash;

    /**
     * 计算hasCode方法，很容易溢出，超出int类型的最大值.
     */
    public int hashCode() {
        if (hash != 0) return hash;
        char[] chars = data.toCharArray();
        int h = 0;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            h = h * 31 + ch;
        }
        hash = h;
        return h;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("data= ").append(data);
        sb.append('}');
        return sb.toString();
    }

    public static class LineHash {
        private 哈希冲突[] store;
        private int maxSize;
        private int size;

        public LineHash(int maxSize) {
            this.maxSize = maxSize;
            store = new 哈希冲突[maxSize];
            size = 0;
        }

        /**
         * 哈希元素大小
         */
        public int getSize() {
            return size;
        }

        /**
         * 哈希化函数
         */
        private int hashFunc(int hashCode) {
            return hashCode % maxSize;
        }

        /**
         * 再次哈希化函数
         */
        private int getFuncStep(int hashCode) {
            return 5 - hashCode % 5;
        }

        /**
         * 哈希化插入操作
         */
        public void insert(哈希冲突 value) {
            int hashCode = value.hashCode();
            //得到哈希化之后的值
            int hashIndex = hashFunc(hashCode);
            //通过哈希值，得到步长step
            int step = getFuncStep(hashCode);
            //hashIndex对应的坐标不为null，且没有被删除，那么就查找下一个元素
            //直到找到hashIndex对应位置，元素为空，或者被删除，那么就在这个位置插入新元素
            // 这里没有考虑死循环情况
            while (store[hashIndex] != null && store[hashIndex] != 哈希冲突.deleteItem) {
                hashIndex = hashIndex + step;
                // 不能使用hashIndex == maxSize这个条件了，
                // 因为hashIndex不再是每次自增1，那么就有可能跳过maxSize这个值。
                hashIndex = hashIndex % maxSize;
            }
            store[hashIndex] = value;
            size++;
        }

        /**
         * 哈希化查询操作
         */
        public 哈希冲突 get(int hashCode) {
            //得到哈希值之后的值
            int hashIndex = hashFunc(hashCode);
            //通过哈希值，得到步长step
            int step = getFuncStep(hashCode);
            /** 跳出循环的条件有两个
             *  一是找到一个空白元素，表示没有查到对应元素
             *  二是找到相同hashCode的值，返回它
             *  不能将被删除元素作为循环终止条件，被删除原生只能作为继续查找下一个元素的条件
             * */
            while (store[hashIndex] != null) {
                //如果hashIndex对应位置元素被删除了，那么就查到下一个元素
                //这里千万不能将store[hashIndex] != 哈希冲突.deleteItem判断条件放到while循环中。
                if (store[hashIndex] != 哈希冲突.deleteItem) {
                    哈希冲突 temp = store[hashIndex];
                    if (temp.hashCode() == hashCode) {
                        return temp;
                    }
                }
                hashIndex = hashIndex + step;
                hashIndex = hashIndex % maxSize;
            }
            return null;
        }

        /**
         * 哈希化删除操作
         */
        public 哈希冲突 remove(int hashCode) {
            int hashIndex = hashFunc(hashCode);
            //通过哈希值，得到步长step
            int step = getFuncStep(hashCode);
            /** 跳出循环的条件有两个
             *  一是找到一个空白元素，表示没有查到对应元素
             *  二是找到相同hashCode的值，就将hashIndex对应下标元素换成deleteItem，表示已删除
             *  不能将被删除元素作为循环终止条件,被删除元素只能作为继续查找下一个元素的条件
             * */
            while (store[hashIndex] != null) {
                // 如果hashIndex对应位置元素被删除了，那么就查找下一个元素。
                // 这里千万不能将store[hashIndex] != 哈希冲突.deleteItem判断条件放到while循环中。
                if (store[hashIndex] != 哈希冲突.deleteItem) {
                    哈希冲突 temp = store[hashIndex];
                    if (temp.hashCode() == hashCode) {
                        size--;
                        store[hashIndex] = 哈希冲突.deleteItem;
                        return temp;
                    }
                }
                hashIndex = hashIndex + step;
                hashIndex = hashIndex % maxSize;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        哈希冲突.LineHash lineHash = new 哈希冲突.LineHash(333);
        for (int i = 0; i < 100; i++) {
            哈希冲突 哈希冲突 = new 哈希冲突(i + "_" + i);
            lineHash.insert(哈希冲突);
        }
        System.out.println("size ===== " + lineHash.getSize());

        哈希冲突 key哈希冲突1 = new 哈希冲突("11_11");
        哈希冲突 key哈希冲突2 = new 哈希冲突("22_22");

        //测试查询方法
        System.out.println("get() ==" + lineHash.get(key哈希冲突1.hashCode()));
        System.out.println("get() ==" + lineHash.get(key哈希冲突2.hashCode()));

        // 删除方法是否有效
        System.out.println("remove == " + lineHash.remove(key哈希冲突1.hashCode()));
        // 重复删除不会有异常
        System.out.println("remove == " + lineHash.remove(key哈希冲突1.hashCode()));

        // 删除之后，在哈希表中就查找不到了
        System.out.println("get() == " + lineHash.get(key哈希冲突1.hashCode()));

        // 删除不会影响其他元素。
        System.out.println("get() == " + lineHash.get(key哈希冲突2.hashCode()));
        System.out.println("get() == " + lineHash.get(new 哈希冲突("33_33").hashCode()));
        System.out.println("size === " + lineHash.getSize());

    }
}


