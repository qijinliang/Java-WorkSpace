package com.哈希表;

/** 链地址法
 * 链表，即采用数组和链表结合方式。数组中不在存放真实的值，而是一个链表。
 * 查找的时候，就是先通过哈希化得到的下标，找到数组对应下标存放的链表，
 * 然后再遍历链表，找到hashCode值相等元素。
 *
 */

public class DataItem {

    private String data;

    // 指向下一个DataItem的引用，形成一个链表
    DataItem next;

    public DataItem(String data, DataItem next) {
        this.data = data;
        this.next = next;
    }

    public DataItem(String data) {
        this.data = data;
    }

    public String getData() {

        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DataItem)) return false;
        DataItem other = (DataItem) obj;
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
        private DataItem[] store;
        private int maxSize;
        private int size;

        public LineHash(int maxSize) {
            this.maxSize = maxSize;
            store = new DataItem[maxSize];
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
        public void insert(DataItem value) {
            size++;
            int hashCode = value.hashCode();
            //得到哈希化之后的值
            int hashIndex = hashFunc(hashCode);
            DataItem temp = store[hashIndex];
            //如果对应下标对应元素为空，就将value值存到这个下标位置，value相当于一个俩表
            if (temp == null) {
                store[hashIndex] = value;
                return;
            }

            //利用循环查找，然后将value插入链表尾
            while (true) {
                if (temp.next == null) break;
                ;
                temp = temp.next;
            }
            temp.next = value;
        }

        /**
         * 哈希化查询操作
         */
        public DataItem get(int hashCode) {
            //得到哈希化之后的值
            int hashIndex = hashFunc(hashCode);
            DataItem temp = store[hashIndex];
            //链表为null，没有这个元素，返回null
            if (temp == null) {
                return null;
            }
            //链表不为空就遍历链表，查找hashcode相同的元素，并返回它
            while (temp != null) {
                if (temp.hashCode() == hashCode) {
                    return temp;
                }
                temp = temp.next;
            }
            //链表遍历完之后，还是没有找到，就返回null
            return null;
        }

        /**
         * 哈希化删除操作
         */
        public DataItem remove(int hashCode) {
            //得到哈希化之后的值
            int hashIndex = hashFunc(hashCode);
            DataItem temp = store[hashIndex];
            //链表为null，没有这个元素，返回null
            if (temp == null) {
                return null;
            }
            DataItem prev = null;
            //链表不为空就遍历链表，查找hashcode相同的元素，并返回它
            while (temp != null) {
                if (temp.hashCode() == hashCode) {
                    //如果prev为空，表示temp是链表头，所以要重新给store[hashIndex]数组赋值
                    if (prev == null) {
                        store[hashIndex] = temp.next;
                    }else {
                        //prev不为空，就将它的next指向temp的next，这样就将temp从链表删除了
                        prev.next = temp.next;
                    }
                    size--;
                    return temp;
                }
                temp = temp.next;
            }
            //链表遍历完之后，还是没有找到，就返回null
            return null;
        }
    }


    public static void main(String[] args) {
        DataItem.LineHash lineHash = new DataItem.LineHash(200);
        for (int i = 0; i < 100; i++) {
            DataItem DataItem = new DataItem(i + "_" + i);
            lineHash.insert(DataItem);
        }
        System.out.println("size ===== " + lineHash.getSize());

        DataItem keyDataItem1 = new DataItem("11_11");
        DataItem keyDataItem2 = new DataItem("22_22");


        //测试查询方法
        System.out.println("get() ==" + lineHash.get(keyDataItem1.hashCode()));
        System.out.println("get() ==" + lineHash.get(keyDataItem2.hashCode()));


        // 删除方法是否有效
        System.out.println("remove == " + lineHash.remove(keyDataItem1.hashCode()));
        // 重复删除不会有异常
        System.out.println("remove == " + lineHash.remove(keyDataItem1.hashCode()));

        // 删除之后，在哈希表中就查找不到了
        System.out.println("get() == " + lineHash.get(keyDataItem1.hashCode()));

        // 删除不会影响其他元素。
        System.out.println("get() == " + lineHash.get(keyDataItem2.hashCode()));
        System.out.println("get() == " + lineHash.get(new DataItem("33_33").hashCode()));
        System.out.println("size === " + lineHash.getSize());

    }
}


