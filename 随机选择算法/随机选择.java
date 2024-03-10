package 随机选择算法;
/*
 * 给定整数数组nums和整数k, 返回数组中第k个最大的数
 * 需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素, 时间复杂度O(n), 额外空间复杂度O(1)
 */
public class 随机选择 {
    public static int LEFT = 0;
    public static int RIGHT = 0;

    public static int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    public static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r; ) {
            partition(arr, l, r, arr[l + (int)(Math.random() * (r - l + 1))]);
            if (i < LEFT) {
                r = LEFT - 1;
            } else if (i > RIGHT) {
                l = RIGHT + 1;
            } else {
                ans = arr[i];
                break;
            }
        }
            return ans;
    }

    
    public static void partition(int[] arr, int left, int right, int x) {
        LEFT = left;
        RIGHT = right;
        int index = left;
        while (index <= right) {
            if (arr[index] < x) {
                swap(arr, LEFT++, index++);
            } else if (arr[index] == x) {
                index++;
            } else {
                swap(arr, RIGHT--, index);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
