package Leetcode.数组.从5随机到7随机扩展;

public class RandTo {

    public static void main(String[] args) {
        System.out.println(randTo5());
        System.out.println(randTo7());
        System.out.println(rand01());
        System.out.println(randTo3());
        System.out.println(randTo6());
        System.out.println(randToM(5));
        System.out.println(randToN(5,10));
    }

    /**
     * 给定一个等概率随机产生1~5的随机函数
     */
    public static int randTo5() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 给定一个等概率随机产生1~7的随机函数
     */
    public static int randTo7() {
        int num = 0;
        do {
            num = (randTo5() - 1) * 5 + randTo5() - 1;
        } while (num > 20);
        return num % 7 + 1;
    }

    /**
     * 给定一个以p概率产生0
     */
    public static int rand01p() {
        //可随意改变p
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    /**
     * 给定一个以p概率产生0和1
     */
    public static int rand01() {
        int num;
        do {
            num = rand01p();
        } while (num == rand01p());
        return num;
    }

    /**
     * 扩展
     * 给定一个以p概率产生0~3的函数
     */
    public static int randTo3() {
        return rand01() * 2 + rand01();
    }

    /**
     * 扩展
     * 产生1~6的函数
     */
    public static int randTo6() {
        int num = 0;
        do {
            num = randTo3() * 4 + randTo3();
        } while (num > 11);
        return num % 6 + 1;
    }

    /**
     * 给定一个等概率随机产生1~M的随机函数
     */
    public static int randToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    public static int randToN(int n, int m) {
        int[] nMSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    //把value转成m进制数
    public static int[] getMSysNum(int value, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (value != 0) {
            res[index--] = value % m;
            value = value / m;
        }
        return res;
    }

    // 等概率随机产生一个0~nMsys范围的数，只不过用m进制表达
    public static int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0) {
            start++;
        }
        int index = start;
        boolean lastEqual = true;
        while (index != nMSys.length) {
            res[index] = randToM(m) - 1;
            if (lastEqual) {
                if (res[index] > nMSys[index]) {
                    index = start;
                    lastEqual = true;
                    continue;
                }else {
                    lastEqual = res[index] == nMSys[index];
                }
            }
            index++;
        }
        return res;
    }

    //把m进制数转成十进制数
    public static int getNumFromMSysNum(int[] mSysNum, int m) {
        int res = 0;
        for (int i = 0; i != mSysNum.length; i++) {
            res = res * m + mSysNum[i];
        }
        return res;
    }
}
