package com.翻转二叉树;

class invertTree {
    public TreeNode invertTree(TreeNode root) {
        //递归函数的条件，节点为空返回
        if (root == null) {
            return null;
        }
        //将当前界面的左右子树进行交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前的节点，左子树
        invertTree(root.left);
        //递归交换当前的节点，右子树
        invertTree(root.right);
        //交换完比
        return  root;
    }
}