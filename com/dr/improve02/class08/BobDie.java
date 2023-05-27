package com.dr.improve02.class08;

public class BobDie {
    public static String bob1(int N, int M, int i, int j, int k) {
        long all = (long) Math.pow(4, k);
        long live = process(N, M, i, j, k);

        // 求最大公约数
        long gcd = gcd(all, live);

        // 以最简的形式返回
        return String.valueOf((live / gcd) + "/" + (all / gcd));
    }

    // N * M的区域，bob在(row,col)位置，走rest步之后，获得的生存点数
    public static long process(int N, int M, int row, int col, int rest) {
        // 初始位置就越界了
        if (row < 0 || row == N || col < 0 || col ==M) {
            return 0;
        }
        // row, col没越界
        if (rest == 0) {
            return 1;
        }

        // 还没走完，row,col也没越界
        long live = process(N, M, row - 1, col, rest - 1);
        live += process(N, M, row + 1, col, rest - 1);
        live += process(N, M, row, col - 1, rest - 1);
        live += process(N, M, row, col + 1, rest - 1);
        return live;
    }

    // 辗转相除法求最大公约数
    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
