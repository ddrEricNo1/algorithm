package BinaryTree_05;

import java.util.Stack;

public class InOrderTraversal {
    public class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void inOrderTraversalRecursion(Node head) {
        if (head == null) {
            return;
        }
        inOrderTraversalRecursion(head.left);
        System.out.println(head.value);
        inOrderTraversalRecursion(head.right);
    }

    public static void inorderTraversalNoRecursion(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }
}
