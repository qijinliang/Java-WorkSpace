package com.翻转二叉树;

import java.util.LinkedList;
import java.util.Queue;

class ReverseBinaryTree {
//    public static Node invertTree(Node root) {
//        //递归函数的条件，节点为空返回
//        if (root == null) {
//            return null;
//        }
//        //将当前界面的左右子树进行交换
//        Node tmp = root.right;
//        root.right = root.left;
//        root.left = tmp;
//        //递归交换当前的节点，左子树
//        invertTree(root.left);
//        //递归交换当前的节点，右子树
//        invertTree(root.right);
//        //交换完比
//        return  root;
//    }

    /**
     * 反转二叉树
     * 这里采用层序遍历的方式来反转，其实采用哪一种遍历方式都可以，但是要通过迭代的方式，不通过递归的方式不好实现
     *
     * @param node
     */
    public static void reverseBinaryTree(Node<Integer> node) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);

        Node<Integer> tempNode = null;
        while (!queue.isEmpty()) {
            //这里要注意从队列中拿出来的其实就是二叉树中的节点，并不是新生成的节点，所以每次拿出一个节点都把这个节点的左右
            //孩子进行反转，那当一颗二叉树遍历完之后所有的节点都会反转
            Node<Integer> root = queue.poll();
            System.out.println(root.element);
            tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;

            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree();
        //    4
        //  2   7
        // 1 3 6 9
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(9);
        reverseBinaryTree(binaryTree.root);
        //    4
        //  7   2
        // 9 6 3 1
    }

}