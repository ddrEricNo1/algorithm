package com.dr.basic01.BucketSortingAndSortingSummary_03;

public class HeapSorting {
    public static void heapSorting(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;
//        for (int i = 0; i < arr.length; i++) {  // O(N)
//            heapInsert(arr, i); // O(logN)
//        }

        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 某个数现在在index的位置，需要继续向上移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) + 1;
        while (left < heapSize) {
            int largest = (left + 1 < heapSize) && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[index] >= arr[largest]) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = (index << 1) + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 4, 6, 7, 0};
        heapSorting(arr);
        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
}
