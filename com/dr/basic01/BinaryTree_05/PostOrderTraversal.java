package com.dr.basic01.BinaryTree_05;

import java.util.Stack;

public class PostOrderTraversal {
    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    // 后序遍历的递归方式
    public static void postOrderTraversalRecursion(Node head) {
        if (head == null) {
            return;
        }
        postOrderTraversalRecursion(head.left);
        postOrderTraversalRecursion(head.right);
        System.out.println(head.value);
    }

    // 后序遍历的非递归方式
    public static void postOrderTraversalNoRecursion(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> collection = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            collection.push(cur);
        }
        while (!collection.isEmpty()) {
            Node cur = collection.pop();
            System.out.println(cur.value);
        }
    }
}
