package BinaryTree_05;

import java.util.*;

public class MaxWidth {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // 求二叉树的最大宽度，使用哈希表的方法
    public static int maxWidthHash(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        queue.add(head);
        map.put(head, 1);

        // 记录当前遍历到的高度
        int height = 1;

        // 记录每一层的节点数
        int curLevelNum = 0;

        // 记录当前遍历到的最大宽度
        int max = -1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curLevel = map.get(cur);
            if (curLevel == height) {
                curLevelNum++;
            } else {
                max = Math.max(max, curLevelNum);
                curLevelNum = 1;
                height++;
            }
            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, curLevel + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, curLevel + 1);
            }
        }
        return max;
    }

    // 不用哈希表的方法
    public static int maxWidthWithoutHash(Node head) {
        if (head == null) {
            return 0;
        }
        int width = 0;
        Queue<Node> queue = new LinkedList<>();

        // 当前层的最后一个节点
        Node curEnd = null;

        // 下一层的最后一个节点
        Node nextEnd = null;

        queue.add(head);
        int nodesCount = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 判断是否有左右子节点
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            nodesCount++;
            if (curEnd == cur) {
                width = Math.max(width, nodesCount);
                nodesCount = 0;
                curEnd = nextEnd;
            }
        }
        return width;
    }
}
