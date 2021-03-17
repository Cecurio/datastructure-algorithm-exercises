/**
 * @author shanxiaokai
 * @date 2021/3/17 20:46
 */
public class Solution2 {
    private int setBitToZero(int res, int i) {
        res &= ~(1 << i);
        return res;
    }

    public int rangeBitwiseAnd(int left, int right) {
        int i = 0;
        while (right > left) {
            int temp = right & (1 << i);
            if (temp != 0) {
                right = setBitToZero(right, i);
            }
            i++;
        }
        return right;
    }

    void f1() {
        int m = 0x4a;
        int n = 0x4e;
        int i = 0;
        while (n > m) {
            int temp = n & (1 << i);
            if (temp != 0) {
                n = setBitToZero(n, i);
            }
            i++;
        }
        System.out.println(String.format("%x", n));
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.rangeBitwiseAnd(1, 2147483647));
        System.out.println(sol.rangeBitwiseAnd(5, 7));
        System.out.println(sol.rangeBitwiseAnd(0, 0));
        System.out.println(sol.rangeBitwiseAnd(1, 1));
    }
}
