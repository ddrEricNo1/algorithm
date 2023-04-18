package com.dr.basic01.Graph_06;

import java.util.*;

public class TopologySort {
    public static List<Node> sortedTopology(Graph graph) {
        // key: 某一个node
        // value: 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();

        // 入度为0的点才能进队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node: graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next: cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
