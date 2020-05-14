package misc;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {

        int res = 0; // Initialize result

        while (m > 0 && n > 0) {

            // Find positions of MSB in x and y
            int msb_m = msbPos(m);
            int msb_n = msbPos(n);

            // If positions are not same, return
            if (msb_m != msb_n)
                break;

            // Add 2^msb_m to result
            int msb_val = (1 << msb_m);
            res = res + msb_val;

            // subtract 2^msb_m from x and y.
            m = m - msb_val;
            n = n - msb_val;
        }

        return res;
    }

    public int msbPos(int n)
    {

        int msb = -1;
        while (n > 0) {
            n = n >> 1;
            msb++;
        }

        return msb;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while(n>m)
            n = n & n-1;
        return m&n;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange obj = new BitwiseANDofNumbersRange();
        System.out.println(obj.rangeBitwiseAnd(5,  7));
        System.out.println(obj.rangeBitwiseAnd(0,  2147483647));
        System.out.println(obj.rangeBitwiseAnd(2147483640,  2147483647));
        System.out.println(obj.rangeBitwiseAnd2(5,  7));
        System.out.println(obj.rangeBitwiseAnd2(0,  2147483647));
        System.out.println(obj.rangeBitwiseAnd2(2147483640,  2147483647));

    }
}
