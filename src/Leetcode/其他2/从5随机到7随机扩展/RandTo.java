package Leetcode.其他2.从5随机到7随机扩展;

public class RandTo {

    public static void main(String[] args) {
        System.out.println(randTo5());
        System.out.println(rand01p());
        System.out.println(randToM(5));
    }

    /**
     * 给定一个等概率随机产生1~5的随机函数
     * */
    public static int randTo5() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 给定一个以p概率产生0
     * */
    public static int rand01p() {
        //可随意改变p
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    /**
     * 给定一个等概率随机产生1~M的随机函数
     */
    public static int randToM(int m) {
        return (int) (Math.random() * m) + 1;
    }
}
