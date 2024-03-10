package 归并分治;

/*
 * 给定一个数组nums
 * 如果i < j 并且nums[i] > 2 * nums[j], 称(i, j)为一个翻转对
 * 返回数组中所有翻转对数量
 */
public class 翻转对数量 {
    public static int MAXN = 50001;
    public static int[] helper = new int[MAXN];
    public static int[] arr = new int[MAXN];
    public static int n;

    public static int reversePairs(int[] arr) {
        return counts(arr, 0, arr.length - 1);
    }

    // 统计l...r 范围上，翻转对的数量，同时l...r范围统计完之后变有序
    public static int counts(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int middle = (l + r) / 2;
        return counts(arr, l, middle) + counts(arr, middle + 1, r) + merge(arr, l, middle, r);
    }
    
    public static int merge(int[] arr, int left, int middle, int right) {
        // 统计部分
        int l = left, r = middle + 1;
        int ans = 0;
        for (; l <= middle; l++) {
            // 乘2可能会溢出，因此转换成long类型比较安全
            while (r <= right && (long)arr[l] > (long)arr[r] * 2) {
                r++;
            }
            ans += r - middle - 1;
        }

        // 合并部分
        int index = left;
        l = left;
        r = middle + 1;
        while (l <= middle && r <= right) {
            helper[index++] = (arr[l] <= arr[r]) ? arr[l++] : arr[r++];
        }

        while (l <= middle) {
            helper[index++] = arr[l++];
        }

        while (r <= right) {
            helper[index++] = arr[r++];
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
