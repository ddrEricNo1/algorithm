package com.dr.improve02.class06;

public class GetMax {
    // 保证参数n不是0就是1
    // 1 -> 0
    // 0 -> 1
    public static int flip(int n) {
        return n ^ 1;
    }

    // n是非负数，返回1
    // n是负数，返回0
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    // 这个方法中a - b有可能溢出
    public static int getMax1(int a, int b) {
        // 获取a和b的差值
        int c = a - b;  // a - b有可能会溢出
        // 获取a的符号位
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        // 获取三个符号状态
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        // 判断a,b符号是否一致，若一致则该值为0，不一样则为1
        int difSab = sa ^ sb;

        // a,b符号状态相同为1，不同为0
        int sameSab = flip(difSab);

        // 返回a的情况：a,b符号不同，并且a为正数，或者a,b符号相同，并且a,b的差值非负
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
}
