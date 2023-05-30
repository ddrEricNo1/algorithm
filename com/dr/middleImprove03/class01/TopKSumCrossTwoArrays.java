package com.dr.middleImprove03.class01;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKSumCrossTwoArrays {
    public static class Node {
        public int index1;
        public int index2;
        public int sum; // arr1[index1] + arr2[index2]的值

        public Node(int i1, int i2, int s) {
            index1 = i1;
            index2 = i2;
            sum = s;
        }
    }

    // 生成大根堆比较器
    public static class MaxHeapComp implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.sum - o1.sum;
        }
    }

    public static int[] topKSum(int[] arr1, int[] arr2, int topK) {
        if (arr1 == null || arr2 == null || topK < 1) {
            return null;
        }

        // 防止需要的数据过多,先处理topK的大小
        topK = Math.min(topK, arr1.length * arr2.length);
        int[] res = new int[topK];
        int resIndex = 0;

        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new MaxHeapComp());

        // 建立判断是否加入过计算的机制
        boolean[][] set = new boolean[arr1.length][arr2.length];
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        maxHeap.add(new Node(i1, i2, arr1[i1] + arr2[i2]));
        set[i1][i2] = true;
        while (resIndex != topK) {
            Node curNode = maxHeap.poll();
            res[resIndex++] = curNode.sum;
            i1 = curNode.index1;
            i2 = curNode.index2;

            // 将左边和上方两个点加入大根堆
            if (i1 - 1 >= 0 && !set[i1 - 1][i2]) {
                // 进来过要在set中标记
                set[i1 - 1][i2] = true;
                maxHeap.add(new Node(i1 - 1, i2, arr1[i1 - 1] + arr2[i2]));
            }
            if (i2 - 1 >= 0 && !set[i1][i2 - 1]) {
                set[i1][i2 - 1] = true;
                maxHeap.add(new Node(i1, i2 - 1, arr1[i1] + arr2[i2 - 1]));
            }
        }
        return res;
    }
}
