package 基数排序;
/*
基于比较的排序，只需要定义两个对象之间如何比较

不基于比较的排序，对于对象数据特征有要求
计数排序，在范围内做词频统计，然后将数据归位，需要知道数据的范围，最好是比较小
基数排序，要求样本是十进制的非负整数
如果有负数，得到最小的负数，并且将数组中所有元素都减去该最小值
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/*
前缀数量分区, 对应数组中的数值为小于等于该值位置一共的个数，最后遍历整个数组的时候需要从右往左遍历，为了保证排序的稳定性 
 */

public class 基数排序 {
    /*
    public static int BASE = 10;
    public static int MAXN = 50001;
    public static int[] arr = new int[MAXN];
    public static int[] helper = new int[MAXN];
    public static int[] counts = new int[BASE];
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
            sort();
            pw.print(arr[0]);
            for (int i = 1; i < n; i++) {
                pw.print(" " + arr[i]);
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static void sort() {
        // 找到数组中的最小值，一般基数排序中只允许数组元素为非负数，但是可以扩展为负数形式, 但是需要对数组中所有元素减去最小的元素，将
        // 数组的值全部改为正数
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        // 对数组中每个元素减去最小值，将所有元素转化为非负数，并且得出其中最大元素，为了方便之后计算最大元素位数，用于基数排序的趟数
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }

        // 根据最大值在BASE进制下的位数，决定基数排序执行多少轮
        radixSort(bits(max));
    }

    public static int bits(int number) {
        int count = 0;
        while (number > 0) {
            number /= BASE;
            count++;
        }
        return count;
    }

    public static void radixSort(int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(counts, 0);
            // 词频统计
            for (int i = 0; i < n; i++) {
                counts[arr[i] / offset % BASE]++;
            }

            // 切换为前缀数量分区
            for (int i = 1; i < BASE; i++) {
                counts[i] = counts[i] + counts[i - 1];
            }

            // 从后往前遍历数组，将元素归位
            for (int i = n-1; i >=0; i--) {
                helper[--counts[arr[i] / offset % BASE]] = arr[i];
            }

            // 将helper数组重新拷贝回原始数组
            for (int i = 0; i < n; i++) {
                arr[i] = helper[i];
            }
        }
    }
    */
    public static int NMAX = 10001;
    public static int[] arr = new int[NMAX];
    public static int BASE = 10;
    public static int[] counts = new int[BASE];
    public static int[] helper = new int[NMAX];
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
            sort();
            pw.print(arr[0]);
            for (int i = 1; i < n; i++) {
                pw.print(" " + arr[i]);
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static int bits(int num) {
        int count = 0;
        while (num > 0) {
            count += 1;
            num /= 10;
        }
        return count;
    }

    public static void sort() {
        // 先得出数组中最小值
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
        }

        // 对数组中所有元素减去min最小值，并得出其中最大的元素
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }

        radixSort(bits(max));
    }

    public static void radixSort(int bits) {
        for (int index = 1; bits > 0; bits--, index*=BASE) {
            Arrays.fill(counts, 0);
            // 词频统计
            for (int i = 0; i < n; i++) {
                counts[arr[i] / index % BASE]++;
            }

            // 将词频统计转换为前缀出现次数和数组
            for (int i = 1; i < n; i++) {
                counts[i] = counts[i] + counts[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                helper[--counts[arr[i] / index % BASE]] = arr[i];
            }

            // 将helper数组重新拷贝回原始arr数组
            for (int i = 0; i < n; i++) {
                arr[i] = helper[i];
            }
        }
    }
}
