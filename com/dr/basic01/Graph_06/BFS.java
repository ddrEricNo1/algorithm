package com.dr.basic01.Graph_06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 宽度优先遍历
public class BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // 判断当前节点是否被遍历过
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next: cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
