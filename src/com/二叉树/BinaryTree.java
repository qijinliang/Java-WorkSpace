package com.二叉树;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {

    /**
     * 二叉树的节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 创建二叉树
     *
     * @param inputList 输入序列号
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }
    /**
     * 二叉树前序遍历
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(" "+node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraveral(node.leftChild);
        System.out.print(" "+node.data);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
        System.out.print(" "+node.data);
    }


    public static void main(String[] args) {
        /** 定义树的结构
         *                 3
         *          2              8
         *      9       10      nul   4
         * null null null null
         * */
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraveral(treeNode);
        System.out.println("");
        System.out.println("中序遍历：");
        inOrderTraveral(treeNode);
        System.out.println("");
        System.out.println("后序遍历：");
        postOrderTraveral(treeNode);
    }
}
