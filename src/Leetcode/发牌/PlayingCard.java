package Leetcode.发牌;

import java.util.Arrays;

public class PlayingCard {

    public static void main(String[] args) {
        //去掉大王和小王，总共52张扑克牌
        String f[] = new String[]{"♡2", "♡3", "♡4", "♡5", "♡6", "♡7", "♡8", "♡9", "♡10", "♡J", "♡Q", "♡K", "♡A", "♥2",
                "♥3", "♥4", "♥5", "♥6", "♥7", "♥8", "♥9", "♥10", "♥J", "♥Q", "♥K", "♥A", "◇2", "◇3", "◇4", "◇5", "◇6",
                "◇7", "◇8", "◇9", "◇10", "◇J", "◇Q", "◇K", "◇A", "♣2", "♣3", "♣4", "♣5", "♣6", "♣7", "♣8", "♣9", "♣10",
                "♣J", "♣Q", "♣K", "♣A"};
        //52 % 4 = 13
        //玩家一
        String w1[] = new String[13];
        //玩家二
        String w2[] = new String[13];
        //玩家三
        String w3[] = new String[13];
        //玩家四
        String w4[] = new String[13];
        //直到发完为止
        String d[] = new String[0];
        for (int i = 0; i < w1.length; ) {
            int b2 = (int) (Math.random() * 52);
            // 没有发出去才会进去 发牌
            if (!f[b2].equals("已发")) {
                // 发牌
                w1[i] = f[b2];
                // 发牌
                f[b2] = "已发";
                i++;
            }

        }

        for (int i = 0; i < w2.length; ) {
            int b2 = (int) (Math.random() * 52);
            // 没有发出去才会进去 发牌
            if (!f[b2].equals("已发")) {
                // 没有发出去才会进去 发牌
                w2[i] = f[b2];
                // 没有发出去才会进去 发牌
                f[b2] = "已发";
                i++;
            }
        }
        for (int i = 0; i < w3.length; ) {
            int b2 = (int) (Math.random() * 52);
            // 没有发出去才会进去 发牌
            if (!f[b2].equals("已发")) {
                // 发牌
                w3[i] = f[b2];
                // 做标记-这张牌已经发出去了
                f[b2] = "已发";
                i++;
            }

        }

        for (int i = 0; i < w4.length; ) {
            int b2 = (int) (Math.random() * 52);
            // 没有发出去才会进去 发牌
            if (!f[b2].equals("已发")) {
                // 发牌
                w4[i] = f[b2];
                // 做标记-这张牌已经发出去了
                f[b2] = "已发";
                i++;
            }

        }

//        for (int i = 0; i < d.length; ) {
//            int b2 = (int) (Math.random() * 52);
//            // 做标记-这张牌已经发出去了
//            if (!f[b2].equals("已发")) {
//                // 做标记-这张牌已经发出去了
//                d[i] = f[b2];
//                // 做标记-这张牌已经发出去了
//                f[b2] = "已发";
//                i++;
//            }
//
//        }

        System.out.println("玩家一" + Arrays.toString(w1));
        System.out.println("玩家二" + Arrays.toString(w2));
        System.out.println("玩家三" + Arrays.toString(w3));
        System.out.println("玩家四" + Arrays.toString(w4));
        System.out.println("查询是否有剩余的牌" + Arrays.toString(d));
    }
}

