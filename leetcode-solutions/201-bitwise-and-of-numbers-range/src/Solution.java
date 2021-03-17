/**
 * @author shanxiaokai
 * @date 2021/3/17 17:22
 */
public class Solution {

    int msb(int m) {
        int count = 0;
        while (m > 0) {
            m = m >> 1;
            count++;
        }
        return count - 1;
    }

    /**
     * 将一个正数的第i位变成1
     * 第n位,第n-1位,第n-2位,...,第1位,第0位
     *
     * @param result
     * @param i
     * @return
     */
    int setBit(int result, int i) {
        return result | (1 << i);
    }

    int getBit(int m, int i) {
        return ((m >> i) & 1);
    }

    public int rangeBitwiseAnd(int left, int right) {
        int msb1 = msb(left);
        int msb2 = msb(right);
        if (msb1 != msb2) return 0;
        int msb = msb1;
        int result = 0;
        while (msb > 0) {
            int x = getBit(left, msb);
            int y = getBit(right, msb);
            if (x != y) {
                break;
            } else {
                if (x == 1) {
                    result = setBit(result, msb);
                }
                msb--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rangeBitwiseAnd(1, 2147483647));
        System.out.println(sol.rangeBitwiseAnd(5, 7));
        System.out.println(sol.rangeBitwiseAnd(0, 0));
        System.out.println(sol.rangeBitwiseAnd(1, 1));
    }
}
