package 堆结构常见题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class 最小数组和减半次数 {
    public static int MAXN = 10001;
    public static int n;
    public static double[] arr = new double[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)st.nval;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i] = st.nval;
                st.nextToken();
            }
            pw.println(compute1());
        }
        pw.flush();
        pw.close();
        br.close();
    }

    // 不加任何优化的方法
    public static int compute1() {
        size = 0;
        int ans = 0;
        double sum = 0;
        for (double val: arr) {
            heapInsert(val);
            sum += val;
        }
        sum /= 2;
        for (double minus = 0, cur = 0; minus < sum; ans++, minus += cur) {
            cur = pop() / 2;
            heapInsert(cur);
        }
        return ans;
    }

    // 需要重新实现一个long类型的堆
    public static int compute2(int[] nums) {
        size = nums.length;
        int ans = 0;
        // 将sum和转变为long类型，int是四字节占32位，long占64位，向右移动20位留出20位缓冲区
        long sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            heap[i] = (long)(nums[i] << 20);
            sum += heap[i];
            heapify(i);
        }

        sum /= 2;
        for (long minus = 0; minus < sum; ans++) {
            heap[0] /= 2;
            minus += heap[0];
            heapify(0);
        }
        return ans;
    }

    // 手写大根堆的实现, 第一种方式，用double存储数组元素
    public static int size = 0;
    public static double[] heap = new double[MAXN];

    public static void heapInsert(double x) {
        int i = size; 
        heap[size++] = x;
        while (heap[i] > heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static double pop() {
        double top = heap[0];
        swap(0, --size);
        heapify(0);
        return top;
    }

    public static void heapify(int i) {
        int l = 2 * i + 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
            best = heap[best] > heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            l = 2 * i + 1;
        }
    }

    public static void swap(int i, int j) {
        double tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
