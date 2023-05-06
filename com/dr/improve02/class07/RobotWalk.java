package com.dr.improve02.class07;

public class RobotWalk {
    public static int walkWays1(int N, int E, int S, int K) {
        return f1(N, E, K, S);
    }

    // N: 表示共有N个位置
    // E: 最终目标
    // rest: 目前机器人还剩多少步
    // cur: 机器人当前所在位置
    // 返回方法数
    public static int f1(int N, int E, int rest, int cur) {
        // 终止条件
        // 还剩0步，如果当前位置为E, 则找到一种方法
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        // 还有步数可以选择
        // 来到1位置
        // 必须走到2
        if (cur == 1) {
            return f1(N, E, rest - 1, 2);
        }

        // 走到N位置
        // 必须走到N - 1
        if (cur == N) {
            return f1(N, E, rest - 1, N - 1);
        }
        // 某个中间位置
        return f1(N, E, rest - 1, cur - 1) + f1(N, E, rest - 1, cur + 1);
    }

    public static int walkWays2(int N, int E, int S, int K) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(N, E, K, S, dp);
    }

    public static int f2(int N, int E, int rest, int cur, int[][] dp) {
        // 该状态已经计算过了
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }

        if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }

        if (cur == 1) {
            dp[rest][cur] = f1(N, E, rest - 1, 2);
        } else if (cur == N) {
            dp[rest][cur] = f1(N, E, rest - 1, N - 1);
        } else {
            dp[rest][cur] = f1(N, E, rest - 1, cur - 1) + f1(N, E, rest - 1, cur + 1);
        }
        return dp[rest][cur];
    }
}
