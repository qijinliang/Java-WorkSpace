package com.二叉树;

import com.mj.example.BinarySearchTree;
import com.mj.printer.BinaryTrees;

import java.util.Random;

public class TestMJprinter {
    private  static class PrintTree extends BinarySearchTree<Integer> {

    }

    public static void main(String[] args) {
        PrintTree tree = new PrintTree();
        for (int i = 0; i < 10 ; i++) {
            tree.add(new Random().nextInt(100));
        }
        BinaryTrees.println(tree);
    }
}
