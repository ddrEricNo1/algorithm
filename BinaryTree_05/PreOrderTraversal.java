package BinaryTree_05;

import java.util.Stack;

public class PreOrderTraversal {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // 前序遍历的递归实现
    public static void preOrderTraversalRecursion(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preOrderTraversalRecursion(head.left);
        preOrderTraversalRecursion(head.right);
    }

    // 前序遍历的非递归实现
    public static void preOrderTraversalNoRecursion(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
}
