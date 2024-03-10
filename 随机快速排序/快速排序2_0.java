package 随机快速排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class 快速排序2_0 {
    public static int NMAX = 10001;
    public static int[] arr = new int[NMAX];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        // 等待多个测试用例
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)st.nval;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i] = (int)st.nval;
            }
            QuickSort2(0, n -1);
            pw.print(arr[0]);
            for (int i = 1; i < n; i++) {
                pw.print(" " + arr[i]);
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }

    public static int Left = 0;
    public static int Right = 0;

    public static void QuickSort2(int left, int right) {
        if (left >= right) {
            return;
        }

        int x = arr[left + (int)(Math.random() * (right - left + 1))];
        partition2(left, right, x);
        int l = Left;
        int r = Right;
        QuickSort2(left, l - 1);
        QuickSort2(r + 1, right);
    }

    // 基于荷兰国旗问题的优化
    public static void partition2(int left, int right, int x) {
        Left = left;
        Right = right;
        int index = left;
        while (index <= Right) {
            if (arr[index] < x) {
                swap(Left++, index++);
            } else if (arr[index] == x) {
                index++;
            } else if (arr[index] > x) {
                swap(Right--, index);
            }
        }
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
