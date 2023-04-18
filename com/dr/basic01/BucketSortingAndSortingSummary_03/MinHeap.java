package com.dr.basic01.BucketSortingAndSortingSummary_03;

import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        // 优先级队列底层是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(8);
        heap.add(4);
        heap.add(4);
        heap.add(9);
        heap.add(10);
        heap.add(3);

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
