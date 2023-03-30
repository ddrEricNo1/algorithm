package BinaryTree_05;

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
}
