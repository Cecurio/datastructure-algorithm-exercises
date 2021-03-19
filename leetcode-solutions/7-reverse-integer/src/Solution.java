/**
 * @author shanxiaokai
 * @date 2021/3/18 23:19
 */
public class Solution {
    public int reverse(int x) {
        int flag = x < 0 ? -1 : 1;
        x = x > 0 ? x : -x;
        int num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x = x / 10;
            if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return flag * num;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(1534236469));
    }
}