package 堆结构常见题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class 线段最多重合问题 {
    public static int MAXN = 10001;
    public static int[][] arr = new int[MAXN][2];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)st.nval;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i][0] = (int)st.nval;
                st.nextToken();
                arr[i][1] = (int)st.nval;
            }
            pw.println(compute());
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static int compute() {
        // 堆清空
        size = 0;
        
        // 按照线段的开始位置进行排序
        Arrays.sort(arr, 0, n, (a, b) -> {
            return a[0] - b[0];
        });

        // 最后返回的答案
        int ans = 0;
        // 遍历所有的线段，并且按照结束位置进入小根堆
        for (int i = 0; i < n; i++) {
            // 每次加入新的线段之前，先将原始线段数组中对计算当前线段重合次数无关的线段弹出 
            while (size > 0 && heap[0] <= arr[i][0]) {
                pop();
            }
            // 将当前线段加入小根堆中
            heapInsert(arr[i][1]);
            ans = Math.max(ans, size);
        }
        return ans;
    }

    // 下面是手写堆的过程, 创建小根堆
    public static int size;
    public static int[] heap = new int[MAXN];

    public static void heapInsert(int x) {
        int i = size;
        heap[size++] = x;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int x, int i) {
        int l = 2 * i + 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
            best = heap[best] < heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            l = 2 * i + 1;
        }
    }
    
    public static int pop() {
        int top = heap[0];
        swap(0, --size);
        heapify(heap[0], 0);
        return top;
    }

    public static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
