package com.dr.basic01.BinaryTree_05;

import java.util.Stack;

// 判断是否为搜索二叉树
public class TestBST {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    // 上次处理到的节点
    public static int preValue = Integer.MIN_VALUE;

    // 利用中序遍历
    public boolean testBSTRecursion(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBST = testBSTRecursion(head.left);
        if (!isLeftBST) {
            return false;
        }

        // 判断该节点是否比上次处理到的节点大
        if (head.val <= preValue) {
            return false;
        } else {
            preValue = head.val;
        }
        return testBSTRecursion(head.right);
    }

    // 非递归方式判断，同样利用中序遍历
    public boolean testBSTWithoutRecursion(Node head) {
        if (head == null) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.val <= preValue) {
                    return false;
                } else {
                    preValue = head.val;
                }
                head = head.right;
            }
        }
        return true;
    }

    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;
        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnData process(Node x) {
        if (x == null) {
            return null;
        }
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);

        int min = x.val;
        int max = x.val;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= x.val)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= x.val)) {
            isBST = false;
        }

        return new ReturnData(isBST, min, max);
    }
}
