package com.dr.basic01.TrieAndGreedyAlgorithm_07;

public class NQueens {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    // i表示目前来到第几行
    // record表示之前摆的皇后都在record中,之前一定不共行，列和斜线
    // record[0...i-1]
    // n代表一共有多少行
    // 返回值是合法的摆法
    public static int process1(int i, int[] record, int n) {
        // 终止行,当前来到了终止行，前面records中默认存在一种摆法
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { // 当前行在第i行，尝试所有的列
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // 常数优化的版本
    // 不要超过32皇后问题
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // 只运用位信息，比如9皇后问题就是9个1
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    public static int process2(int limit,
                               int colLim,
                               int leftDiaLim,
                               int rightDiaLim) {
        // 列上限制为1表示已经算完最后一行
        if (colLim == limit) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        // 所有候选皇后的位置
        pos = limit & (~(colLim | leftDiaLim | rightDiaLim));

        int res = 0;
        while (pos != 0) {
            // 提取出候选皇后最右边的1
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        // 不用判断是否共行，因为是一行一行加入的
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
