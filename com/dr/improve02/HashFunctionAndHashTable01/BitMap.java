package com.dr.improve02.HashFunctionAndHashTable01;

public class BitMap {
    public static void main(String[] args) {
        int a = 0;
        // 每个位置32bit,一共可表示长度为320bit的bit数组
        int[] arr = new int[10];

        // 想取到178个bit的状态
        int i = 178;

        // 去int数组的哪个index中查找
        int numIndex = 178 / 32;

        // 去index中哪个bit位上查找
        int bitIndex = 178 % 32;

        // 拿到第178位的状态
        int s = ((arr[numIndex] >> bitIndex) & 1);

        // 将178位状态改为1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);
    }
}
