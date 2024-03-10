import java.io.IOException;

public class 归并排序 {
    public static int NMAX = 5000;
    public static int arr[] = new int[NMAX];
    public static int helper[] = new int[NMAX];
    public static int n;    // 数组的长度

    public static void main(String[] args) throws IOException {
        // 对数器
        int N = 5000;   // 数组的最大长度
        int V = 400;
        int[] arr = randomArray(N, V);
        mergeSort(0, arr.length);
    }

    public static int[] randomArray(int N, int V) {
        int length = (int)(Math.random() * N);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random() * V);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static boolean isSameArray(int[] arr1, int[] arr2) {
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void mergeSort(int left, int right) {
        if (left == right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        merge(left, middle, right);
    }

    public static void merge(int left, int middle, int right) {
        int l = left, r = middle + 1;
        int index = l;
        while (l <= middle && r <= right) {
            helper[index++] = (arr[l] < arr[r]) ? arr[l++] : arr[r++];
        }
        while (l <= middle) {
            helper[index++] = arr[l++];
        }

        while (r <= right) {
            helper[index++] = arr[r++];
        }

        // 将helper数组重新拷贝回原始arr数组
        for (int i = left; i <= right; i++) {
            arr[i] = helper[i];
        }
    }

    public static int first = 0;    // 存储左边范围的第一个右边的越界位置
    public static int second = 0;   // 存储右边范围的第一个左边的越界位置
    // 快速排序
    public static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        // 获取数组中随机一个位置的元素
        int x = arr[left + (int)(Math.random() * (right - left + 1))];
        partition(left, right, x);
        int l = first;
        int r = second;
        quickSort(left, l - 1);
        quickSort(r + 1, right);
    }

    // 快速排序2.0版本，基于荷兰国旗问题的实现优化
    public static void partition(int left, int right, int x) {
        int l = left, r = right;    // 左边界的越界位置和右边界的越界位置
        int index = left;
        while (left <= r) {
            if (arr[index] < x) {
                swap(l++, index++);
            } else if (arr[index] == x) {
                index++;
            } else {
                swap(r--, index);
            }
        }
    }

    // 基于快速排序1.0的版本，将小于等于x的部分都放在左边，大于x的都放在右边
    public static int partition2(int left, int right, int x) {
        int x_index = 0;
        int l = 0;  // 左边小于等于x的右边界的越位位置
        for (int index = left; index <= right; index++) {
            if (arr[index] <= x) {
                swap(l, index);
            }
            if (arr[index] == x) {
                x_index = index;
            }
            l++;
        }
        swap(x_index, l - 1);
        return x_index;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
