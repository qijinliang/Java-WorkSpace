package Leetcode.二叉树.统计完美二叉树节点数;

public class nodeNum {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {

            this.val = x;
        }

    }

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
        return bs(root,1,mostLeftLevel(root,1));
    }

    public static void main(String[] args) {
//             10
//          11    14
//        12  15 16 13
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(11);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(16);
        TreeNode node6 = new TreeNode(13);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.print(printTreeNum(root));
    }
}
