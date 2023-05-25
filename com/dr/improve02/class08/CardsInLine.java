package com.dr.improve02.class08;

public class CardsInLine {
    // 暴力递归的方式
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(
                f(arr, 0, arr.length - 1),
                s(arr, 0, arr.length - 1)
        );
    }

    // 先手函数
    // 当前该自己先拿
    // 返回最好分数
    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, R),
                        arr[R] + s(arr, L, R - 1)
                        );
    }

    // 后手函数
    // 当前对方先在arr[L...R]范围上拿
    // 返回自己的最好分数
    public static int s(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(f(arr, L + 1, R),
                        f(arr, L, R - 1)
        );
    }
}
