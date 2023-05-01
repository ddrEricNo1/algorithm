package com.dr.improve02.class05;

// 用Morris遍历判断是否为搜索二叉树
public class isBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        Node cur = head;
        Node mostRight = null;
        int preValue = Integer.MIN_VALUE;

        while (cur != cur) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (cur.value <= preValue) {
                return false;
            }
            preValue = cur.value;
            cur = cur.right;
        }
        return true;
    }
}
