package Leetcode.其他.发红包;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class divideRedPackage {

    /**
     * 拆分红包
     *
     * @param totalAmount    总金额(以分为单位)
     * @param totalPeoPleNum 总人数
     */

    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeoPleNum) {
        List<Integer> amountList = new ArrayList<Integer>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeoPleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeoPleNum - 1; i++) {
            //随机范围：[1，剩余人均金额的2倍-1]分
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(10000, 10);
        for (Integer amount : amountList) {
            System.out.println("抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }
}
