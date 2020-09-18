package Leetcode.二叉树.是否为平衡二叉树;

import Leetcode.二叉树.公共.TreeNode;
import mj.example.BinarySearchTree;
import mj.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

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


        TreeNode root = TreeNode.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        root.show(root);
        System.out.println("---------------------");
        System.out.print(isBalance(root));
    }


}
