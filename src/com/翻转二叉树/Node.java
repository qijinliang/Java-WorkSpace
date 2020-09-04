package com.翻转二叉树;

//节点代码
public class Node<E> {
    public Node<E> left;
    public Node<E> right;
    public Node<E> parent;
    public E element;

    public Node(E element) {
        this.element = element;
    }
}