package com.dr.improve02.KMP03;

public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        // 获得str2的next数组
        int[] next = getNextArray(str2);

        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (i2 == 0) {   // next[i2] == -1
                // i2 已经在0位置了，没有办法往前跳,让str1换一个开头，即往下走一个index
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        // i1 越界或者i2越界
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        // 人为规定0和1index位置的值
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        // cn表示用哪个位置的字符和i-1位置的字符比较
        int cn = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            }
            // 当前跳到cn位置的字符上，和i-1位置的字符匹配不上
            else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
