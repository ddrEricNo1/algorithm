package 随机快速排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class 快速排序1_0 {
    public static int MAXN = 1001;
    public static int[] arr = new int[MAXN];
    public static int n;    // 文件中数组长度的大小
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
        }
        quickSort1(0, n - 1);
        pw.print(arr[0]);
        for (int i = 0; i < n; i++) {
            pw.print(" " + arr[i]);
        }
        pw.flush();
        pw.close();
    }

    // 1.0版本，将所有小于等于的全部放在最左边
    // 改进策略是基于荷兰国旗问题，将等于x的元素位置全部放在中间，并排除，只去处理大于和小于x的部分长度
    public static void quickSort1(int left, int right) {
        if (left >= right) {
            return;
        }
        int x = arr[left + (int)(Math.random() * (right - left + 1))];
        int mid = partition1(left, right, x);
        quickSort1(left, mid);
        quickSort1(mid + 1, right);
    }

    public static int partition1(int left, int right, int x) {
        int a = 0;  // 表示小于等于x的右边界越界位置
        int xi = 0; // 记录当前遇到的恰好等于x的元素
        for (int i = left; i <= right; i++) {
            if (arr[i] <= x) {
                swap(a, i);
            }
            if (arr[i] == x) {
                xi = i;
            }
            a++;
        }
        swap(xi, a - 1);
        return a - 1;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
