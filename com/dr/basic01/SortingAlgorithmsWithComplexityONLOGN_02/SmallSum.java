package com.dr.basic01.SortingAlgorithmsWithComplexityONLOGN_02;
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid)
                +
                process(arr, mid + 1, right)
                +
                merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int sum = 0;
        int[] help = new int[right - left + 1];
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                sum += arr[p1] * (right - p2 + 1);
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
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
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }
}
