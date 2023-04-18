package com.dr.basic01.BinaryTree_05;

public class IsBalanced {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }

        // 返回值的类型
        public static class ReturnType {
            public boolean isBalanced;
            public int height;
            public ReturnType(boolean isBalanced, int height) {
                this.isBalanced = isBalanced;
                this.height = height;
            }
        }

        public static boolean isBalanced(Node head) {
            return process(head).isBalanced;
        }

        public static ReturnType process(Node x) {
            if (x == null) {
                return new ReturnType(true, 0);
            }
            ReturnType leftData = process(x.left);
            ReturnType rightData = process(x.right);

            int height = Math.max(leftData.height, rightData.height) + 1;
            boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                    && Math.abs(leftData.height - rightData.height) < 2;
            return new ReturnType(isBalanced, height);
        }

    }
}
