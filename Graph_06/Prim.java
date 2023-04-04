package Graph_06;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        // 存储已经遍历到的节点
        HashSet<Node> set = new HashSet<>();

        // 存储依次挑选出来的边
        Set<Edge> result = new HashSet<>();
        for (Node node: graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                // 将该节点对应的边全部加入小根堆
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    // 弹出解锁的边中最小的一条边
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                    }
                    for (Edge nextEdge: toNode.edges) {
                        priorityQueue.add(nextEdge);
                    }
                }
            }

        }
        return result;
    }
}
