package Leetcode.二叉树.统计完美二叉树节点数;

import Leetcode.二叉树.公共.TreeNode;


public class nodeNum {


    public int TreeNodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public static int bs(TreeNode node, int l, int h) {
        if (l == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, l + 1) == h) {
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    public static int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static int printTreeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return bs(root, 1, mostLeftLevel(root, 1));
    }

    public static void main(String[] args) {


        TreeNode root = TreeNode.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        root.show(root);
        System.out.println("---------------------");
        System.out.print("树的所有节点为：" +printTreeNum(root));
    }
}
