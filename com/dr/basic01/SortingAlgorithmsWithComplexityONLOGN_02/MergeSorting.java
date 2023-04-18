package com.dr.basic01.SortingAlgorithmsWithComplexityONLOGN_02;
public class MergeSorting {
    public static void mergeSorting(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i=0;
        int p1=left;
        int p2=mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 6, 8, 7, 5, 3, 4, 1, 2, 0};
        mergeSorting(arr);
        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
}
