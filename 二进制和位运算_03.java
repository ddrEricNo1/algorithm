public class 二进制和位运算_03 {
    // 用于以二进制形式打印一个数字
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 78;
        System.out.println(a);
        printBinary(a);

        int b = -6;
        System.out.println(b);
        printBinary(b);

        int f = Integer.MAX_VALUE;
        printBinary(f);

        int min = Integer.MIN_VALUE;
        printBinary(min);

        // 相反数, 整数最小值的相反数还是自己，也就是说最小整数的绝对值仍然是负数
        // 所有数位取反，末尾+1 
        System.out.println(a);
        System.out.println(~a + 1);
    }
}
