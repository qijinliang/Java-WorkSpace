package Leetcode.二叉树.是否为平衡二叉树;

import Leetcode.二叉树.公共.TreeNode;

public class isBalance {

    public static boolean isBalance(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }


    public static void main(String[] args) {

        // 根据给定的数组创建一棵树
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        // 将刚刚创建的树打印出来
        root.show(root);
        System.out.print(isBalance(root));
    }
}
