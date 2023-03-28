package BucketSortingAndSortingSummary_03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorForMinHeap {
    public static class AComp implements Comparator<Integer> {
        // 返回负数，认为第一个数应该放在上面
        // 返回正数，认为第一个数应该放在下面
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new AComp());
        heap.add(6);
        heap.add(9);
        heap.add(3);
        heap.add(2);
        heap.add(10);

        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
