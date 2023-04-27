package com.dr.improve02.Manacher04;

public class Manacher {
    public static char[] manacherString(String s) {
        char[] charArr = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }
    // 最长回文半径
    public static int maxLcpsLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1; // 中心
        int R = -1; // 回文右边界再往右一个位置，最右的有效区域是R-1位置
        int max = Integer.MIN_VALUE;    // 扩出来的最大值
        for (int i = 0; i != str.length; i++) { // 每一个位置都需要求回文半径
            /*
            i在R外, 不用验的区域为自己，1
            i'在[L...R]内,
            i'在[L...R]外
            i'区域压线
             */
            // R > i表示i在R内或压线，不大于表示i在R外，至少不用验证的区域为1
            // i 在R内，至少不用验证的区域为两个瓶颈中最小的
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            // 默认各种情况都往外扩，其中有两种只要扩大一次就会失败
            // 为了简化代码
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else{
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
}
