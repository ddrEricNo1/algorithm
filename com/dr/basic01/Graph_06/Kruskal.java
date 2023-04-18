package com.dr.basic01.Graph_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kruskal {
    public static class MySets {
        public HashMap<Node, List<Node>> setMap;
        public MySets(List<Node> nodes) {
            for (Node cur: nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        // 判断from和to是否在同一个集合中
        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        // 把from和to集合合并成一个集合
        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            // 把toSet所有节点加入fromSet中
            for (Node toNode: toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    // 需要使用并查集
    // 之后再实现
}
