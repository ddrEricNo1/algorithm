package BinaryTree_05;

import java.util.LinkedList;
import java.util.Queue;

// 判断一棵二叉树是否为完全二叉树
public class IsCompleteTree {
    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static boolean isCompleteTree(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个子孩子不全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            l = cur.left;
            r = cur.right;

            // 如果已经有一个左右子节点不双全的节点，并且后续又遇到了非叶子节点
            // 或者当前节点有右子节点但没有左子节点
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right !=null) {
                queue.add(cur.right);
            }
            if (l == null && r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static class ReturnData {
        // 高度
        public int height;

        // 节点个数
        public int nodes;

        public ReturnData(int height, int nodes) {
            this.nodes = nodes;
            this.height = height;
        }
    }

    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new ReturnData(height, nodes);
    }

    // 满二叉树的递归套路
    public static boolean isFull(Node head) {
        if (head == null) {
            return true;
        }
        ReturnData info = process(head);
        return info.nodes == ((1 << info.height) - 1);
    }
}
