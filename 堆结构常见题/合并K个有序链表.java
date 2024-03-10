package 堆结构常见题;

import java.util.ArrayList;

public class 合并K个有序链表 {
    public class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeKLists(ArrayList<ListNode> arr) {
        for (ListNode cur: arr) {
            if (cur != null) {
                heapInsert(cur);
            }
        }
        if (size == 0) {
            return null;
        }
        ListNode head = pop();
        ListNode curNode = head;
        if (head.next != null) {
            heapInsert(head.next);
        }

        while (size > 0) {
            curNode.next = pop();
            curNode = curNode.next;
            if (curNode.next != null) {
                heapInsert(curNode.next);
            }
        }
        return head;
    }

    // 手写一个小根堆
    public static int MAXN = 10001;
    public static ListNode[] heap = new ListNode[MAXN];
    public static int size; // 堆的元素个数

    // 插入一个新的元素
    public static void heapInsert(ListNode x) {
        int i = size - 1;
        heap[size++] = x;
        while (heap[i].val < heap[(i - 1) / 2].val) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // 弹出堆顶元素
    public static ListNode pop() {
        ListNode top = heap[0];
        swap(0, --size);
        heapify(0);
        return top;
    }

    public static void heapify(int i) {
        int left = 2 * i + 1;
        while (left < size) {
            int best = left + 1 < size && heap[left + 1].val < heap[left].val ? left + 1 : left;
            best = heap[best].val < heap[i].val ? best : i;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            left = 2 * i + 1;
        }
    }

    public static void swap(int i, int j) {
        ListNode tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
