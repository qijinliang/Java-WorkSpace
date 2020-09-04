package com.翻转二叉树;
//二叉树构成代码：

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;

public class BinaryTree<E> {

    private int size;
    public Node<E> root;
    private Comparator<E> comparator;

    public BinaryTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinaryTree() {
        this(null);
    }

    public void add(E element) {
        if (root == null) {
            Node node = new Node(element);
            root = node;
        } else {
            Node<E> parent = root;
            Node<E> node = root;
            int com = 0;
            while (node != null) {
                parent = node;
                if (comparator == null) {
                    com = ((Comparable) node.element).compareTo(element);
                } else {
                    System.out.println("-------------");
                    com = comparator.compare(node.element, element);
                }
                if (com > 0) {
                    node = node.left;
                } else if (com < 0) {
                    node = node.right;
                } else {
                    node.element = element;
                    return;
                }
            }
            Node<E> newNode = new Node(element);
            if (com > 0) {
                parent.left = newNode;
                newNode.parent = parent.left;
            } else {
                parent.right = newNode;
                newNode.parent = parent.right;
            }
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String d = root == null ? null : root.element + "";
        if (root == null) {
            return "root:" + d;
        } else {
            String b = root.left == null ? null : root.left.element + "";
            String c = root.right == null ? null : root.right.element + "";
            return "root:" + d + ", left:" + b + ", right:" + c;
        }

    }


    public static void main(String[] args) {
        //这种方式就是匿名内部类，通过给一个类传一个接口作为参数，然后这个通过一个匿名内部类是实现这个接口来传入实现。
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        BinaryTree<Integer> binaryTree1 = new BinaryTree<>();
        binaryTree1.add(1);
        binaryTree1.add(2);
        binaryTree1.add(0);
        System.out.println(binaryTree1.size());
        System.out.println(binaryTree.toString());
    }
}
