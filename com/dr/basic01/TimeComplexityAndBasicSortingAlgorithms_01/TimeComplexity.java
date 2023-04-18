package com.dr.basic01.TimeComplexityAndBasicSortingAlgorithms_01;

public class TimeComplexity {
    //一个数组中只有一个数字出现奇数次，其余均出现偶数次，找到这个数
    public static void printOddTimesNum1(int[] arr){
        int num=0;
        for(int val:arr){
            num=num^val;
        }
        System.out.println(num);
    }

    //一个数组中有两个不同的数字出现了奇数次，其余均出现偶数次，找到这两个数
    public static void printOddTimesNum2(int[] arr){
        int num=0;
        for(int val:arr){
            num=num^val;
        }

        //找到最右边那个不为1的值
        int rightOne=num&(~num+1);

        //a和b中其中一个数
        int element=0;

        //找出数组中onlyOne位为1的所有数
        for(int val:arr){
            if((val&rightOne)==1){
                element=element^val;
            }
        }

        int element2=num^element;

        System.out.println("a: "+element+",b: "+element2);
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,2,3};
        printOddTimesNum1(arr);

        int[] arr2={1,1,1,2,2,3,3,3,3,4,5,5,5,5};
        printOddTimesNum2(arr2);
    }
}
