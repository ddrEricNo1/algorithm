package 位运算;

// 判断一个数是不是2的幂
public class powerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && n == (n & (~n + 1));
    }

    public static boolean isPowerOfThree(int n) {
        // 1162261467是int范围内，最大的3的幂, 是3的19次方
        return n > 0 && 1162261467 % n == 0;
    }

    // 已知n是一个非负数，返回大于等于n的最小的2的幂
    public static int near2Power(int n) {
        if (n <= 0) {
            return 1;
        }
        // 将最左侧的1之后的所有数位全部赋值为1
        n--;
        n |= (n >>> 1);
        n |= (n >>> 2);
        n |= (n >>> 4);
        n |= (n >>> 8);
        n |= (n >>> 16);
        return n + 1;
    }

    // 区间[left, right] 内所有数字&的结果
    public static int leftToRightAnd(int left, int right) {
        // 如果left小于right,并且right最右边为1，则最右边的1肯定无法留下，因为right-1之后的数字最后一位为0，与之后的结果也为0
        while (left < right) {
            // 依次减掉最右边的1
            right -= right & (~right + 1);
        }
        return right;
    }

    // 逆序一个数字的二进制表示状态
    public static int reverse(int n) {
        // 本质上是相邻两两交换之后合成一个大组，大组间再两两交换，直到大组个数为16，进行两两交换
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        return (n >>> 16) | (n << 16);
    }

    // 返回一个数二进制中有几个1
    // 思路和上面一个题差不多, 都是通过相邻两个组之间的计数去判断
    public static int countOne(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
