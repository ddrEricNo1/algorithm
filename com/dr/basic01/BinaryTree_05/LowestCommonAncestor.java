package com.dr.basic01.BinaryTree_05;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    public static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    // o1,o2一定属于head为头的树
    // 返回公共最低祖先节点
    public static Node lca(Node head, Node o1, Node o2) {
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set1 = new HashSet<>();
        Node cur = o1;
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        cur = o2;
        while (cur != fatherMap.get(cur)) {
            if (set1.contains(cur)) {
                return cur;
            } else {
                cur = fatherMap.get(cur);
            }
        }
        return null;
    }

    public static void process(Node head, HashMap<Node, Node> map) {
        if (head == null) {
            return;
        }
        map.put(head.left, head);
        map.put(head.right, head);
        process(head.left, map);
        process(head.right, map);
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}
