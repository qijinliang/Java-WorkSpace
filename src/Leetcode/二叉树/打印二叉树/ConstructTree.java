package Leetcode.二叉树.打印二叉树;

import Leetcode.二叉树.公共.TreeNode;

public class ConstructTree {


    public static void main(String[] args) {
        /*树的结构示例：
              1
            /   \
          2       3
         / \     / \
        4   5   6   7
        */

        // 根据给定的数组创建一棵树
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        // 将刚刚创建的树打印出来
        root.show(root);
    }
}

