package com.dr.improve02.class05;

/*
树形DP
得到二叉树最大距离
 */
public class MaxDistanceInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    // 返回信息：最大距离和高度
    public static class Info {
        public int maxDistance;
        public int height;
        public Info(int dis, int h) {
            this.maxDistance = dis;
            this.height = h;
        }
    }

    // 返回以x为头的整棵树信息
    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }

        // 用黑盒的过程
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        // 左树中最大距离
        int p1 = leftInfo.maxDistance;
        // 右树中最大距离
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + 1 + rightInfo.height;
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, height);
    }
}
