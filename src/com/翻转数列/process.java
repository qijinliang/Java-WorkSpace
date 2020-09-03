package com.翻转数列;

//*链接：https://www.nowcoder.com/questionTerminal/cc0a71a1dfdb4c64a3ffe000f71ae12c?toCommentId=1859430
//来源：牛客网
//小Q定义了一种数列称为翻转数列:
//给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
//例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
//而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
//小Q现在希望你能帮他算算前n项和为多少。
//*/

import java.util.*;

//输入包括两个整数n和m(2 <= n <= 109, 1 <= m), 并且满足n能被2m整除。
//输出一个整数, 表示前n项和。
import java.util.*;
public class process {
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        System.out.println((n / (m << 1)) * (m * m));
    }
}
