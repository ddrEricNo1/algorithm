package com.dr.basic01.BucketSortingAndSortingSummary_03;

import java.util.PriorityQueue;

public class SortedArrDistanceLessK {
    public static void sortedArrDistanceLessk(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        int i = 0;
        for(; index <= Math.min(arr.length, k); index++) {
            minHeap.add(arr[index]);
        }
        for (; index<arr.length; index++, i++) {
            minHeap.add(arr[index]);
            arr[i] = minHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll();
        }
    }

    public static void main(String[] args) {

    }
}
