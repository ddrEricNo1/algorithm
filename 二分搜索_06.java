/*
 * 二分搜索
1. 在有序数组中判断一个数是否存在
2. 在有序数组中找>=num的最左位置
3. 在有序数组中找<=num的最右位置
4. 找区间中的最值
 */

import java.util.Arrays;

public class 二分搜索_06 {
    // 判断一个数字是否存在
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    // 用对数器验证二分搜索的正确性
    public static boolean right(int[] sortedArr, int num) {
        for (int cur: sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    // 有序数组中找到大于等于num的最左位置
    public static int findLeft(int[] arr, int num) {
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            // 记答案往左
            if (arr[m] >= num) {
                ans = m;
                r = m - 1;
            } else {    // 不记答案往右
                l = m + 1;
            }
        }
        return ans;
    }

    // 对数器比较的暴力方法
    public static int bruteforceFindLeft(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    // 有序数组中找到小于等于num的最右位置
    public static int findRight(int[] arr, int num) {
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m] <= num) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n -1;
        }
        int l = 1, r = n - 2, m = 0, ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m - 1] > arr[m]) {
                r = m - 1;
            } else if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 50000;
        System.out.println("start testing");
        for (int i = 0; i < testTime; i++) {
            int n = (int)(Math.random() * N);
            int[] arr = Comparator_05.randomArray(n, V);
            Arrays.sort(arr);
            int num = (int)(Math.random() * N);
            if (right(arr, num) != exist(arr, num)) {
                System.out.println("error");
            }
        }
        System.out.println("testing finished");
    }
}
