package 位运算;

/*
袋子中有a个白球，b个黑球，每次从袋子中拿2个球，每个球每次被拿出来的概率相等，
如果拿出的是两个白球，或者两个黑球，就往袋子中重新放一个白球，如果拿出来的是一个黑球，一个白球，就重新往袋子中放一个黑球
问：最终袋子中一定会只剩下一个球，请问最终的球是黑色的概率是多少，用a和b表达这个概率
答案：黑球数量如果是偶数，最终不可能是黑球，如果黑球数量是奇数，最后一定是黑球

想象白球为0，黑球为1，无进位相加只和黑球数量（1）相关
*/

public class 异或运算 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 6, 6, 6};
        int[] result = findTwoNumber(nums);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static void swap(int a, int b) {
        // 交换两个数的值, 前提是a和b有自己的内存空间, 如果a和b是在相同的位置，最后会变成0, 知道这种写法就行，不推荐
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a= " + a + ", b= " + b);
    }

    public static int flip(int num) {
        return num ^ 1;
    }

    // 非负返回1，负数返回0
    public static int sign(int num) {
        // 这里无符号右移的原因，如果num是负数，用0补齐
        return flip(num >>> 31);
    }

    // 不用任何判断和比较操作，返回两个数字的最大值, 有溢出风险
    public static int compare1(int a, int b) {
        // 得到差值之后，查看差值的符号位，c非负，得到1，如果c是负数，返回0
        int c = a - b;
        int returnA = sign(c);
        int returnB = flip(returnA);
        return a * returnA + b + returnB;
    }

    // 没有任何问题的实现
    public static int compare2(int a, int b) {
        int c = a - b;  // c 可能是溢出的
        // 判断是否溢出，先拿到abc的符号
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffAB = sa ^ sb;   // 判断ab符号是否不一样, 如果一样为0，不一样为1
        int sameAB = flip(diffAB);  // 判断ab符号是否一样，如果一样为1，不一样为0

        // 返回a的条件：ab符号不一样，且a非负, a和b符号一样，但是c非负
        int returnA = diffAB * sa + sameAB * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    // 找到缺失的数字, 将所有数字进行亦或就可以
    public static int missingValue(int[] nums) {
        int eorAll = 0, eorHas = 0;
        for (int i = 0; i < nums.length; i++) {
            eorHas ^= nums[i];
            eorAll ^= i;
        }
        eorAll ^= nums.length;
        return eorAll ^ eorHas;
    }

    // 数组中有一个数字出现了奇数次，其余都出现了偶数次, 找到出现奇数次的数
    public static int findOddNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    // 数组中有两个数字出现了奇数次，其余均出现了偶数次，返回这两个数
    public static int[] findTwoNumber(int[] nums) {
        int eorAll = 0;
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= nums[i];
        }
        
        // 提取出结果中最右边的1
        int rightOne = eorAll & (~eorAll + 1);
        int eor1 = 0;
        for (int i = 0; i < nums.length; i++) {
            // rightOne将整个数组分成两个部分，对应位置为1的和对应位置不为1的
            if ((nums[i] & rightOne) == 0) {    // 只和对应位置为1的数字进行异或操作
                eor1 ^= nums[i];
            }
        }
        return new int[]{eor1, eorAll^eor1};
    }

    // 一个数组中只有一个数字出现次数小于m次，其余出现的次数都为m次，请找到这个数字 
    public static int findLessThanMTimesValue(int[] arr, int M) {
        // 作为每个数字位置上的计数
        int[] count = new int[32];
        // 统计每个位置上元素出现的个数，如果不能整除m，则表示需要找的数字在该位置上为1
        for (int val: arr) {
            for (int i = 0; i < 32; i++) {
                count[i] += ((val >> i) & 1);
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % M != 0) {
                result = result | (1 << i);
            }
        }
        return result;
    }
}
