package com.dr.basic01.BucketSortingAndSortingSummary_03;

public class RadixSorting {
    public static void radixSorting(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSorting(arr, 0, arr.length - 1, maxbits(arr));
    }

    // 读取数组中最大值的数位
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[begin...end]排序
    // digit表示这一批数中最大的数有几个十进制位
    public static void radixSorting(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0;
        int j = 0;
        // 有多少数就准备多少辅助空间
        int[] bucket = new int[R - L + 1];
        // 入桶出桶的次数
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                 j = getDigit(arr[i], d);
                 count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / (int) Math.pow(10, d - 1)) % 10);
    }

    public static void main(String[] args) {

    }
}
