package com.dr.basic01.TimeComplexityAndBasicSortingAlgorithms_01;

public class Sorting {
    //选择排序
    public static void SelectionSorting(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }

        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i;j<arr.length;j++){
                minIndex=arr[j]<arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
        for(int val:arr){
            System.out.print(val+" ");
        }
    }

    public static void BubbleSorting(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=arr.length-1;i>0;i--){
            
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1,0};
        SelectionSorting(arr);
    }
}
