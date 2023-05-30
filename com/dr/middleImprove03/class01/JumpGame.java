package com.dr.middleImprove03.class01;

public class JumpGame {
    public static int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 跳了多少步
        int jump = 0;
        // jump步内的右边界
        int cur = 0;
        // jump + 1步内的右边界
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }
}
