package SortingAlgorithmsWithComplexityONLOGN_02;
public class QuickSorting {
    public static void quickSorting(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int)(Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            process(arr, left, p[0] - 1);
            process(arr, p[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        // i和大于区域撞上时停止循环
        while (L < more) {
            if (arr[L] < arr[R]) {  // 当前数小于划分值
                swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, R, more);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 4};
        quickSorting(arr);
        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
}
