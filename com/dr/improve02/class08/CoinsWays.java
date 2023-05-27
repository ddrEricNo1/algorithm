package com.dr.improve02.class08;

public class CoinsWays {
    public static int way1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        // 已经没有货币可以选择
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += process(arr, index + 1, rest - arr[index] * zhang);
        }
        return ways;
    }

    public static int way2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        dp[N][0] = 1;
        for (int row = N - 1; row >= 0; row--) {
            for (int col = 0; col <= aim; col++) {
                int ways = 0;
                for (int zhang = 0; arr[row] * zhang <= col; zhang++) {
                    ways += dp[row + 1][col - arr[row] * zhang];
                }
                dp[row][col] = ways;
            }
        }
        return dp[0][aim];
    }

    public static int way3(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        dp[N][0] = 1;
        for (int row = N - 1; row >= 0; row--) {
            for (int col = 0; col <= aim; col++) {
                dp[row][col] = dp[row + 1][col];
                if (col - arr[row] >= 0) {
                    dp[row][col] += dp[row][col - arr[row]];
                }
            }
        }
        return dp[0][aim];
    }

    // 对数器
    // for test
    public static int[] generateRandomArray(int len, int max) {
        int[] arr = new int[(int)(Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(len, max);
            int aim = (int)(Math.random() * 3 * max) + max;
            if (way1(arr, aim) != way2(arr, aim) || (way1(arr, aim) != way3(arr, aim))) {
                System.out.println("ooops!");
                break;
            }
        }
    }
}
