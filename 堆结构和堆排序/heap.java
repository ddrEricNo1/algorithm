package 堆结构和堆排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class heap {
    /*
    public static int NMAX = 50001;
    public static int[] arr = new int[NMAX];
    public static int n;    // 数组长度

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)st.nval;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i] = (int)st.nval;
            }
            heapSort2();
            pw.print(arr[0]);
            for (int i = 1; i < n; i++) {
                pw.print(" " + arr[i]);
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }

    // 自顶向下建堆,时间复杂度为O(NlogN)
    public static void heapSort1() {
        for (int i = 0; i < n; i++) {
            heapInsert(i);
        }
        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }

    // 自底向上建堆，时间复杂度为O(N)
    public static void heapSort2() {
        for (int i = n - 1; i >= 0; i--) {
            heapify(i, n);
        }
        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }
    
    public static void heapify(int i, int size) {
        int l = 2 * i + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            l = 2 * i + 1;
        }
    }

    // i 位置的数，向上调整大根堆
    public static void heapInsert(int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    */

    public static int NMAX = 50001;
    public static int[] arr = new int[NMAX];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)st.nval;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i] = (int)st.nval;
            }
            heapSort2();
            pw.print(arr[0]);
            for (int i = 1; i < n; i++) {
                pw.print(" " + arr[i]);
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }

    // 自顶向下的建堆，时间复杂度为O(N)
    public static void heapSort1() {
        for (int i = 0; i < n; i++) {
            heapInsert(i);
        }

        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }

    public static void heapSort2() {
        int size = n;
        for (int i = size - 1; i >= 0; i--) {
            heapify(i, size);
        }

        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }

    // 默认大根堆
    public static void heapInsert(int i) {
        while (arr[i] > arr[ (i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int i, int size) {
        int l = 2 * i + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            l = 2 * i + 1;
        }
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
