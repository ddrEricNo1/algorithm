package com.dr.improve02.HashFunctionAndHashTable01;

public class Islands {
    // 主方法
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    // 感染过程
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    // 感染过程
    // 递归方法
    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }

        // i, j没越界，并且当前位置值是1
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = {
                {0, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        int res = countIslands(m1);
        System.out.println(res);
    }
}
