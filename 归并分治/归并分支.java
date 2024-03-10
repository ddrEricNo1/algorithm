package 归并分治;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class 归并分支 {
    // 思考一个问题在大范围上的答案，是否等于左部分的答案+右部分的答案+跨越左右的答案
    // 计算跨越左右产生的答案时，如果加上左右有序的设定，能否获得计算上的便利性
    // 如果以上两点都成立，该问题很有可能能被归并分治解决
    // 小和问题
    /*
    假设数组 s = [1, 3, 5, 2, 4, 6]
    在s[0]左边所有<=s[0]的数总和为0
    在s[1]左边所有<=s[1]的数总和为1
    在s[2]左边所有<=s[2]的数总和为4
    在s[3]左边所有<=s[3]的数总和为1
    在s[4]左边所有<=s[4]的数总和为6
    在s[5]左边所有<=s[5]的数总和为15
    给定一个数组，实现一个函数返回数组的所有元素的小和之和
     */
    public static int NMAX = 100001;
    public static int[] arr = new int[NMAX];
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
            pw.println(smallSum(0, n - 1));
        }
        pw.flush();
        pw.close();
    }

    // 返回跨越左右产生的小和, 并且左，右各自有序，让整体有序
    // 返回值是long的原因：累加的小和值可能比较大，超过了整型的范围 
    public static long merge(int left, int middle, int right) {
        long ans  = 0;
        for (int j = middle + 1, i = left, sum = 0; j <= right; j++) {
            while (i <= middle && arr[i] <= arr[j]){
                sum += arr[i++];
            }
            ans += sum;
        }


        // 正常merge 
        int l = left, r = middle + 1;
        int index = left;
        while (l <= middle && r <= right) {
            helper[index++] = (arr[l] <= arr[r]) ? arr[l++] : arr[r++];
        }
        while (l <= middle) {
            helper[index++] = arr[l++];
        }

        while (r <= right) {
            helper[index++] = arr[r++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = helper[i];
        }

        return ans;
    }

    public static long smallSum(int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = (left + right) / 2;
        // 左边产生的小和+右边范围内产生的小和+跨越左右范围产生的小和
        return smallSum(left, middle) + smallSum(middle + 1, right) + merge(left, middle, right);
    }

    public static void mergeSort(int left, int right) {
        int middle = (left + right) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        merge(left, middle, right);
    }
}
