package com.二叉树;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public static void perOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(" " + node.data);
        perOrderTraversal(node.leftChild);
        perOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树非递归前序遍历
     *
     * @param root 二叉树根节点
     */
    public static void perOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左节点，并入栈
            while (treeNode != null) {
                System.out.print(" " + treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左节点，则弹出栈顶节点，访问节点右节点
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树中序遍历
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        perOrderTraversal(node.leftChild);
        System.out.print(" " + node.data);
        perOrderTraversal(node.rightChild);
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
        perOrderTraversal(node.leftChild);
        perOrderTraversal(node.rightChild);
        System.out.print(" " + node.data);
    }

    /**
     * 二叉树层序遍历
     *
     * @param root 二叉树跟节点
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(" " + node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }


    public static void main(String[] args) {
        /** 定义树的结构
         *                 3
         *          2              8
         *      9       10      11   4
         * null null null null
         * */
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, 11, 4));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        perOrderTraversal(treeNode);
        System.out.println("");
        System.out.println("非递归前序遍历：");
        perOrderTraversalWithStack(treeNode);
        System.out.println("");
        System.out.println("中序遍历：");
        inOrderTraversal(treeNode);
        System.out.println("");
        System.out.println("后序遍历：");
        postOrderTraveral(treeNode);
        System.out.println("");
        System.out.println("层序遍历：");
        levelOrderTraversal(treeNode);

    }

}
