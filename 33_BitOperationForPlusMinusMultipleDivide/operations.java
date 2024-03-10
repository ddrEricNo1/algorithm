public class operations {
    public static int MIN = Integer.MIN_VALUE;

    // use bit operation for add
    public static int add(int val1, int val2) {
        int ans = val1;
        while (val2 != 0) {
            ans = val1 ^ val2;
            val2 = (val1 & val2) << 1;
            val1 = ans;
        }
        return ans;
    }

    // bit operation for minus
    public static int minus(int val1, int val2) {
        return add(val1, neg(val2));
    }

    // change the current value to its negative one
    private static int neg(int val) {
        return add(~val, 1);
    }

    // bit operation for multiply
    public static int multiply(int val1, int val2) {
        int ans = val1;
        while (val2 != 0) {
            if ((val2 & 1) != 0) {
                ans = add(ans, val1);
            }
            val1 <<= 1;
            val2 >>>= 1;
        }
        return ans;
    }

    // bit operation for divide
    // avoid val1 and val2 is the minimum of the integer, otherwise, it cannot be converted to its 
    // negative version
    public static int div(int val1, int val2) {
        int x = val1 < 0 ? neg(val1) : val1;
        int y = val2 < 0 ? neg(val2) : val2;

        int ans = 0;
        // right shift from 30th bit, because the 31th bit represents the symbol
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return (val1 < 0) ^ (val2 < 0) ? neg(ans) : ans;
    }

    public static int divide(int val1, int val2) {
        if (val1 == MIN && val2 == MIN) {
            return 1;
        }

        if (val1 != MIN && val2 != MIN) {
            return div(val1, val2);
        }

        if (val2 == MIN) {
            return 0;
        }

        if (val1 == MIN && val2 == -1) {
            return Integer.MAX_VALUE;
        }

        // a is the minimum value of integer, b is neither -1 nor the minimum value of integer
        val1 = add(val1, val2 > 0 ? val2 : neg(val2));
        int ans = div(val1, val2);
        int offset = val2 > 0 ? neg(1) : 1;
        return add(ans, offset);
    }
}
