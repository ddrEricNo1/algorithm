package TrieAndGreedyAlgorithm_07;

/*
一块金条切成凉拌，需要花费和长度数值一样的铜板，比如金条长度为20，不管切成长度多大的两半，都需要花费20铜板
一群人想争分整块金条，怎么分最省铜板
 */

import java.util.PriorityQueue;

/*
例如：给定数组[10,20,30]代表一共3个人，整块金条长度为60，金条要分成10，20，30三部分，如果先分为10，50，再把50分为20和30，一共需要110
如果先分为30，30，再把其中一个30分为10和20，一共需要90
 */
public class LessMoney {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (queue.size() > 1) {
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }
}
