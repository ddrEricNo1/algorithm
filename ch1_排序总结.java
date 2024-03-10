import java.util.Arrays;

public class ch1_排序总结 {

    // 插入排序, 时间复杂度为O(N^2), 空间复杂度为O(1)
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
    
    // 选择排序
    public static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = arr[i];
            int min_index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[i] < min) {
                    min = arr[i];
                    min_index = i;
                }
            }
            swap(arr, i, min_index);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int end = length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }
    
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] randomArray(int N, int V) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int)(Math.random() * (V + 1));
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int length = arr.length;
        int[] newArr = new int[length];
        for (int i = 0; i < length; i++) {
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

    public static void main(String[] args) {
        int N = 10000;
        int V = 1000;
        int testTime = 5000;
        System.out.println("start testing");
        for (int i = 0; i < testTime; i++) {
            int length = (int)(Math.random() * (N + 1));
            int[] base = randomArray(length, V);
            int[] arr1 = copyArray(base);
            Arrays.sort(base, 0, length);
            bubbleSort(arr1);
            if (!isSameArray(base, arr1)) {
                System.out.println("not pass");
            } else {
                System.out.println("pass");
            }
        }
        System.out.println("end testing");
    }
}
