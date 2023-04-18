package com.dr.basic01.SortingAlgorithmsWithComplexityONLOGN_02;

public class ReverseOrders {
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 1){
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    public static int process(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(nums, left, mid)
                + process(nums, mid + 1, right)
                + merge(nums, left, mid, right);
    }

    public static int merge(int[] nums, int left, int mid, int right) {
        int store_left = left;
        int[] help=new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int counter = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] > nums[p2]) {
                counter += mid - p1 + 1;
                p1++;
                help[left++] = nums[p2++];
            } else {
                help[left++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            help[left++] = nums[p1++];
        }

        while (p2<= right) {
            help[left++] = nums[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[store_left + i] = help[i];
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr= {5, 4, 1};
        System.out.println(reversePairs(arr));
    }
}
