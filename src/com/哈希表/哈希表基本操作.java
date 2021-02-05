package com.哈希表;

public class 哈希表基本操作 {
    private String data;

    /**
     * 用deleteItem这个静态变量标记已经删除元素
     * 因为在链表删除的时候，是不能将数组的元素位置null，用这个标记
     */
    public static final 哈希表基本操作 deleteItem = new 哈希表基本操作();

    public 哈希表基本操作() {

    }

    public 哈希表基本操作(String data) {
        this.data = data;
    }

    public String getData() {

        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof 哈希表基本操作)) return false;
        哈希表基本操作 other = (哈希表基本操作) obj;
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
        private 哈希表基本操作[] store;
        private int maxSize;
        private int size;

        public LineHash(int maxSize) {
            this.maxSize = maxSize;
            store = new 哈希表基本操作[maxSize];
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
         * 哈希化插入操作
         */
        public void insert(哈希表基本操作 value) {
            int hashCode = value.hashCode();
            //得到哈希化之后的值
            int hashIndex = hashFunc(hashCode);
            //hashIndex对应的坐标不为null，且没有被删除，那么就查找下一个元素
            //直到找到hashIndex对应位置，元素为空，或者被删除，那么就在这个位置插入新元素
            // 这里没有考虑死循环情况
            while (store[hashIndex] != null && store[hashIndex] != 哈希表基本操作.deleteItem) {
                hashIndex = hashIndex + 1;
                if (hashIndex == maxSize)
                    hashIndex = 0;
            }
            store[hashIndex] = value;
            size++;
        }

        /**
         * 哈希化查询操作
         */
        public 哈希表基本操作 get(int hashCode) {
            //得到哈希值之后的值
            int hashIndex = hashFunc(hashCode);
            /** 跳出循环的条件有两个
             *  一是找到一个空白元素，表示没有查到对应元素
             *  二是找到相同hashCode的值，返回它
             *  不能将被删除元素作为循环终止条件，被删除原生只能作为继续查找下一个元素的条件
             * */
            while (store[hashIndex] != null) {
                //如果hashIndex对应位置元素被删除了，那么就查到下一个元素
                //这里千万不能将store[hashIndex] != 哈希表基本操作.deleteItem判断条件放到while循环中。
                if (store[hashIndex] != 哈希表基本操作.deleteItem) {
                    哈希表基本操作 temp = store[hashIndex];
                    if (temp.hashCode() == hashCode) {
                        return temp;
                    }
                }
                hashIndex = hashIndex + 1;
                if (hashIndex == maxSize)
                    hashIndex = 0;
            }
            return null;
        }

        /**
         * 哈希化删除操作
         */
        public 哈希表基本操作 remove(int hashCode) {
            int hashIndex = hashFunc(hashCode);
            /** 跳出循环的条件有两个
             *  一是找到一个空白元素，表示没有查到对应元素
             *  二是找到相同hashCode的值，就将hashIndex对应下标元素换成deleteItem，表示已删除
             *  不能将被删除元素作为循环终止条件,被删除元素只能作为继续查找下一个元素的条件
             * */
            while (store[hashIndex] != null) {
                // 如果hashIndex对应位置元素被删除了，那么就查找下一个元素。
                // 这里千万不能将store[hashIndex] != 哈希表基本操作.deleteItem判断条件放到while循环中。
                if (store[hashIndex] != 哈希表基本操作.deleteItem) {
                    哈希表基本操作 temp = store[hashIndex];
                    if (temp.hashCode() == hashCode) {
                        size--;
                        store[hashIndex] = 哈希表基本操作.deleteItem;
                        return temp;
                    }
                }
                hashIndex = hashIndex + 1;
                if (hashIndex == maxSize)
                    hashIndex = 0;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        LineHash lineHash = new LineHash(200);
        for (int i = 0; i < 100; i++) {
            哈希表基本操作 哈希表基本操作 = new 哈希表基本操作(i + "_" + i);
            lineHash.insert(哈希表基本操作);
        }
        System.out.println("size ===== " + lineHash.getSize());

        哈希表基本操作 key哈希表基本操作1 = new 哈希表基本操作("50_50");
        哈希表基本操作 key哈希表基本操作2 = new 哈希表基本操作("25_25");


        //测试查询方法
        System.out.println("get() ==" + lineHash.get(key哈希表基本操作1.hashCode()));
        System.out.println("get() ==" + lineHash.get(key哈希表基本操作2.hashCode()));

        // 删除方法是否有效
        System.out.println("remove == " + lineHash.remove(key哈希表基本操作1.hashCode()));
        // 重复删除不会有异常
        System.out.println("remove == " + lineHash.remove(key哈希表基本操作1.hashCode()));

        // 删除之后，在哈希表中就查找不到了
        System.out.println("get() == " + lineHash.get(key哈希表基本操作1.hashCode()));

        // 删除不会影响其他元素。
        System.out.println("get() == " + lineHash.get(key哈希表基本操作2.hashCode()));
        System.out.println("get() == " + lineHash.get(new 哈希表基本操作("75_75").hashCode()));
        System.out.println("get() == " + lineHash.get(new 哈希表基本操作("755").hashCode()));
        System.out.println("size === " + lineHash.getSize());

    }
}


