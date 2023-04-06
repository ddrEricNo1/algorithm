package TrieAndGreedyAlgorithm_07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node {
        public int p;
        public int c;
        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    // 按照花费的比较器
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MinCostComparator());
        // 所有项目扔到被锁池中，花费组织的小根堆
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }

        // 进行k轮
        for (int i = 0; i < k; i++) {
            // 能力所及的项目，全部解锁
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}
